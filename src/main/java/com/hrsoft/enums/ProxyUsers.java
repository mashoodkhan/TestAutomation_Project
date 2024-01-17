package com.hrsoft.enums;

/**
 * @author Annameni Srinivas
 *         <a href="mailto:annameni.srinivas@hrsoft.com">annameni.srinivas@hrsoft.com</a>
 */
public final class ProxyUsers {
    
    public enum proxyUser {
        AdminUser("admin_user"),
        AnvitaPriyam("anvita.priyam"),
        TusharGhoshal("tushar.ghoshal"),   
        JoePoxson("joe.poxson");
        
        public String userId;
        
        private proxyUser (String userId) {
            this.userId=userId;
            
        }
        
    }

}
