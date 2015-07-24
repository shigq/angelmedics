package com.angelmedics.security;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

//@RestController
//@RequestMapping(value = "/rest/security")
//public class RestAuthenticationController {
//
//    public HttpHeaders getJsonHeaders() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/json");
//        return headers;
//    }
//
//    @RequestMapping(value="/login-page", method = RequestMethod.GET)
//    public ResponseEntity<String> apiLoginPage() {
//        return new ResponseEntity<String>(getJsonHeaders(), HttpStatus.UNAUTHORIZED);
//    }
//
//    @RequestMapping(value="/authentication-failure", method = RequestMethod.GET)
//    public ResponseEntity<String> apiAuthenticationFailure(HttpSession session) {
//        // return HttpStatus.OK to let your front-end know the request completed (no 401, it will cause you to go back to login again, loops, not good)
//        // include some message code to indicate unsuccessful login
//        Exception aa=(Exception) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
//        String res="{success:'false',message:'"+aa.getMessage()+ "'}";
//    	//return new ResponseEntity<String>("{\"success\" : false, \"message\" : \"authentication-failure\"}", getJsonHeaders(), HttpStatus.OK);
//    	return new ResponseEntity<String>(res, getJsonHeaders(), HttpStatus.OK);
//        
//    }
//
//    @RequestMapping(value="/default-target", method = RequestMethod.GET)
//    public ResponseEntity<String> apiDefaultTarget() throws JsonProcessingException {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        // exclude/include whatever fields you need
//        //String userJson = new JSONSerializer().exclude("*.class", "*.password").serialize(authentication);
//        ObjectMapper mapper = new ObjectMapper();  
////        mapper.setSerializationConfig(mapper.getSerializationConfig().withSerializationInclusion( 
////                JsonSerialize.Inclusion.NON_NULL)); 
//        
//      //  mapper.setSerializationConfig(mapper.getSerializationConfig().withSerializationInclusion(incl)
//        
//        String userJson = mapper.writeValueAsString(authentication);  
//        return new ResponseEntity<String>(userJson, getJsonHeaders(), HttpStatus.OK);
//    }
//}

@RestController
@RequestMapping(value = "/rest/security")
public class RestAuthenticationController {


    @RequestMapping(value="/login-page", method = RequestMethod.GET)
    //默认认证的url
    public RestSecurity apiLoginPage(HttpSession session) {
    	RestSecurity rest=new RestSecurity();
    	rest.setStatusCode(HttpStatus.UNAUTHORIZED);
    	rest.setMessage("没有访问资源的权限！"+session.getAttribute("SPRING_SECURITY_SAVED_REQUEST").toString());
    	rest.setSuccess(false);
        return rest;
    }

    @RequestMapping(value="/authentication-failure", method = RequestMethod.GET)
    //认证失败默认跳转url
    public RestSecurity apiAuthenticationFailure(HttpSession session) {

        Exception exception=(Exception) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
    	RestSecurity rest=new RestSecurity();
    	rest.setStatusCode(HttpStatus.OK);
    	rest.setMessage(exception.getMessage());
    	rest.setSuccess(false);
        return rest;
        
    }

    @RequestMapping(value="/default-target", method = RequestMethod.GET)
    //认证成功默认跳转url
    public RestSecurity apiDefaultTarget() throws JsonProcessingException {
    	
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RestSecurity rest=new RestSecurity();
    	rest.setStatusCode(HttpStatus.OK);
    	rest.setMessage("username:" +user.getUsername());
    	rest.setSuccess(true);
        return rest;
    }
}