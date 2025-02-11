package com.shoes_ecommerce_app.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_ADMIN, ROLE_CUSTOMER, ROLE_AGENT, ROLE_CLIENT;

    public String getAuthority() {
        return name();
    }
}
