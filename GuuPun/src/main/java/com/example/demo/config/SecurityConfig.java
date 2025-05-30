package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests() // authorizeRequests() を authorizeHttpRequests() に変更
        .requestMatchers("/h2-console/**").permitAll()  // antMatchers() を requestMatchers() に変更
        .requestMatchers("/", "/index", "/css/**", "/js/**", "/images/**").permitAll()  // 静的リソースへのアクセスを許可
        .requestMatchers("/forgotten_mimolette/**").permitAll()  // /forgotten_mimolette へのアクセスも許可
        .requestMatchers("/the_remains_of_the_artificial_beach/**").permitAll()  // /the_remains_of_the_artificial_beach へのアクセスも許可
        .requestMatchers("/chitchat_cue/**").permitAll()  // /chitchat_cue へのアクセスも許可
        .anyRequest().authenticated()  // 他のURLは認証が必要
        
        .and()
        .formLogin()
        .loginPage("/login")  // 必要ならカスタムログインページを指定
        .defaultSuccessUrl("/forgotten_mimolette", true)  // ログイン後に /forgotten_mimolette にリダイレクト
        .and()
        .csrf().disable()  // CSRFを無効化（H2コンソール使用時に必要）
        .headers().frameOptions().disable();  // フレーム制限を無効化
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // パスワードのエンコードにBCryptを使用
    }
}
