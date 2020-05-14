package org.redhat.aarellan.fuse.cookiehandler;

import java.net.CookiePolicy;

import org.apache.camel.http.common.cookie.InstanceCookieHandler;

public class NettyCookieHandlerRejectAll extends InstanceCookieHandler {

    @Override
    public void setCookiePolicy(CookiePolicy cookiePolicy) {
        super.setCookiePolicy(CookiePolicy.ACCEPT_NONE);
    }
}
