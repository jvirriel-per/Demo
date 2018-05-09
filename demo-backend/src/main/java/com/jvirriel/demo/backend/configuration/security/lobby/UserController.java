package com.jvirriel.demo.backend.configuration.security.lobby;

import com.pt.core.be.controller.AbstractUserController;
import com.pt.util.domain.user.UserData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pt.core.be.constants.GeneralConstants.*;
import static com.pt.util.property.PropertyUtil.getProperty;

@RestController
@RequestMapping(USER_REQUEST_MAPPING)
public class UserController extends AbstractUserController {

    @GetMapping(USERNAME_GET_MAPPING)
    public UserData userData(@RequestHeader(value = USER_TOKEN) String userToken,
                             @RequestHeader(value = APP_COD) String appcod,
                             @RequestHeader(value = APP_COD_ORIGIN) String appcodOrigin) {
        String securityUserNameUri = getProperty(BASE_URL_SECURITY) + URL_USERNAME;

        return getUserDataFromRequest(userToken, appcod, securityUserNameUri);
    }
}