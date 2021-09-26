/*
package com.geekbrains.webapp.springapp.controllers;

import com.geekbrains.webapp.springapp.services.CartService;
import com.geekbrains.webapp.springapp.utils.Cart;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.concurrent.TimeUnit;

@ControllerAdvice
@RequiredArgsConstructor
@Deprecated
public class GlobalController {
    private final CartService cartService;

    @ModelAttribute(value = "cart")
    public Cart cart (@CookieValue(value = "cookieName", required = false) Cookie cookieCartId, HttpServletRequest request, HttpServletResponse response,
                      Principal principal
                      )
    {
        if(cookieCartId == null) {
            Cookie cookie = new Cookie("cookieName", RandomString.make(64));
            cookie.setMaxAge((int) TimeUnit.DAYS.toSeconds(365));
            response.addCookie(cookie);
        }
        return cartService.getCartForCurrentUser();
    }

}
*/
