package com.arthur.bff_gendador_tarefas.infrastructure.security;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SecurityScheme(name = SecurityConfig.SECURITY_SCHEME,
                type = SecuritySchemeType.HTTP,
                bearerFormat = "JWT",
                scheme = "bearer")

public class SecurityConfig {

    public static final String SECURITY_SCHEME = "bearerAuth";
}
