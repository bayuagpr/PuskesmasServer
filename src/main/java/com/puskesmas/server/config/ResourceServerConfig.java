/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puskesmas.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//    @Autowired
//    private ResourceServerTokenServices tokenServices;

//    @Autowired
//    private TokenStore tokenStore;
//    
//    @Autowired
//    private JwtAccessTokenConverter accessTokenConverter;
    
    @Value("${security.jwt.resource-ids}")
    private String resourceIds;
    
    @Value("${security.signing-key}")
	private String signingKey;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
                http
                .requestMatchers()
                .and()
                .authorizeRequests()
                .antMatchers("/actuator/**", "/api-docs/**","/tokens/**").permitAll()
                .antMatchers("/daftarPoli/**",
                        "/diagnosa/**",
                        "/dokter/**",
                        "/HasilLab/**",
                        "/hasilPemeriksaan/**",
                        "/medicalRecord/**",
                        "/obat/**",
                        "/pasien/**",
                        "/pembayaran/**",
                        "/pendaftaran/**",
                        "/resep/**").authenticated()
                .and()
                .sessionManagement()
                .maximumSessions(2).sessionRegistry(sessionRegistry());
    }
    
    @Bean
    public SessionRegistry sessionRegistry() {
    return new SessionRegistryImpl();
    }
    
   @Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(signingKey);
		return converter;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	@Primary //Making this primary to avoid any accidental duplication with another token service instance of the same name
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		return defaultTokenServices;
	}
}
