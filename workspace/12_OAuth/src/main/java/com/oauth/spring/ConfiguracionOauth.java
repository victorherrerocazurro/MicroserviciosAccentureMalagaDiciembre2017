package com.oauth.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class ConfiguracionOauth extends AuthorizationServerConfigurerAdapter {

	private static final Logger log = LoggerFactory.getLogger(ConfiguracionOauth.class);
	
	//Obtencion del properties de la clave privada
	@Value("${config.oauth2.privateKey}")
	private String privateKey;

	//Obtencion del properties de la clave publica
	@Value("${config.oauth2.publicKey}")
	private String publicKey;

	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * Definicion de un Bean que se encarga de gestionar la encriptacion del Token
	 * @return
	 */
	@Bean
	public JwtAccessTokenConverter tokenEnhancer() {
		log.info("Initializing JWT with public key:\n" + publicKey);
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(privateKey);
		converter.setVerifierKey(publicKey);
		return converter;
	}

	/**
	 * Definicion del almacen de Tokens, que emplea el anterior Bean para la encriptacion/desencriptacion
	 * @return
	 */
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(tokenEnhancer());
	}

	/**
	 * Define las condiciones de autenticacion/autorizacion que han de cumplir los clientes para poder acceder a los recursos 
	 * de clave publica "/oauth/token_key" -> tokenKeyAccess
	 * y de verificacion del Token "/oauth/check_token" -> checkTokenAccess
	 *
	 * @param oauthServer
	 * @throws Exception
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer
				.tokenKeyAccess("isAnonymous() || hasRole('ROLE_TRUSTED_CLIENT')") // permitAll()
				.checkTokenAccess("hasRole('TRUSTED_CLIENT')"); // isAuthenticated()
	}

	/**
	 * Define que authentication manager, que almacen de Token y que encriptador de Token se va a emplear.
	 * @param endpoints
	 * @throws Exception
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints

				// Si no se proporciona, no se confgura
				.authenticationManager(authenticationManager)
				// Actores para encriptacion JWT
				.tokenStore(tokenStore())
				.accessTokenConverter(tokenEnhancer());
	}

	/**
	 * Define los usuarios (que serán las aplicaciones cliente) que pueden acceder a los endpoint de gestion del Token. Es por tanto una informacion que el servidor
	 * de auteticacion, podrá extender con algun tipo de logica de registro de aplicaciones clientes.
	 * 
	 * Las aplicaciones cliente pueden ser de diversa tipologia, y por lo tanto se describen distintos AuthorizedGrant
	 */
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()

				// Aplicacion Cliente que almacenará internamente su secret, este secret debe ser secreto, dado que si lo conociesen otras aplicaciones, 
				// podrian pedir datos de usuarios haciendose pasar por esta aplicacion, y el usuario ha podido querer compartir con esta aplicacion su información,
				// pero no con las otras.
				.withClient("confidential") //Identificador de la aplicacion cliente en el servidor de autorizacion.
				.secret("secret")
				.authorizedGrantTypes("client_credentials", "authorization_code", "refresh_token")
				.scopes("read", "write") //Scopes que la aplicacion cliente pedira a cada usuario que le concedan
				.redirectUris("http://localhost:8083/client/") //URL a la que se redirigirá al usuario una vez finalizada la autenticacion

				.and()

				// Aplicaciones cliente no validadas, que podran acceder en principio solo a contenido publico
				.withClient("public") // No secret!
				.authorizedGrantTypes("client_credentials", "implicit")
				.scopes("read")
				.redirectUris("http://localhost:8083/client/")

				.and()

				// Aplicacion Cliente de extrema confianza para el usuario, que puede emplear el propio login/password del usuario en su nombre.
				.withClient("trusted").secret("secret").authorities("ROLE_TRUSTED_CLIENT")
				.authorizedGrantTypes("client_credentials", "password", "authorization_code", "refresh_token")
				.scopes("read", "write")
				.redirectUris("http://localhost:8083/client/");
	}
}
