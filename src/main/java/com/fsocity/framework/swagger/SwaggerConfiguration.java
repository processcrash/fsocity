package com.fsocity.framework.swagger;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.List;

import static java.util.Collections.*;
import static springfox.documentation.schema.AlternateTypeRules.*;

/**
 * @author zail
 * @date 2022/1/24
 */
@Configuration
@EnableSwagger2 // Enables Springfox swagger 2
public class SwaggerConfiguration {
    
    @Autowired
    private TypeResolver typeResolver;
    @Autowired
    private SwaggerConfigurationProperties swaggerConfigurationProperties;
    
    @Bean
    public Docket swaggerApiDocket() {
        // Docket, Springfox’s, primary api configuration mechanism is initialized for swagger specification 2.0
        return new Docket(DocumentationType.SWAGGER_2) // 初始化 Swagger2
                
                // select() returns an instance of ApiSelectorBuilder to give fine grained control over the
                // endpoints exposed via swagger.
                // 对 swagger 进行端点控制
                .select()
                // apis() allows selection of RequestHandler's using a predicate. The example here uses an any
                // predicate (default). Out of the box predicates provided are any, none, withClassAnnotation,
                // withMethodAnnotation and basePackage.
                // 请求处理器对选择
                .apis(RequestHandlerSelectors.any())
                // paths() allows selection of Path's using a predicate. The example here uses an any predicate
                // (default). Out of the box we provide predicates for regex, ant, any, none.
                // 路径的选择
                .paths(PathSelectors.any())
                // The selector needs to be built after configuring the api and path selectors.
                .build()
                
                // Adds a servlet path mapping, when the servlet has a path mapping. This prefixes paths with
                // the provided path mapping.
                // 链接映射的前缀
                .pathMapping("/")
                
                // Convenience rule builder that substitutes LocalDate with String when rendering model properties
                // 当渲染 LodalDate 类型当时候替换成 String。（可以配置多个）
                .directModelSubstitute(LocalDate.class, String.class)
                // .directModelSubstitute(LocalDate.class, String.class)
                
                // 一般模型的替换
                .genericModelSubstitutes(ResponseEntity.class)
                // Convenience rule builder that substitutes a generic type with one type parameter with the type
                // parameter. In this example ResponseEntity<T> with T. alternateTypeRules allows custom rules that
                // are a bit more involved. The example substitutes DeferredResult<ResponseEntity<T>> with T
                // generically.
                .alternateTypeRules(
                        newRule(typeResolver.resolve(DeferredResult.class,
                                        typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                                typeResolver.resolve(WildcardType.class)))
                
                // Flag to indicate if default http response codes need to be used or not.
                // 使用默认的响应信息
                .useDefaultResponseMessages(false)
                
                .globalResponses(
                        HttpMethod.GET,
                        singletonList(new ResponseBuilder()
                                .code("500")
                                .description("500 message")
                                .representation(MediaType.TEXT_XML)
                                .apply(r ->
                                        r.model(m ->
                                                m.referenceModel(ref ->
                                                        ref.key(k ->
                                                                k.qualifiedModelName(q ->
                                                                        q.namespace("some:namespace")
                                                                                .name("ERROR"))))))
                                .build()))
                
                .securitySchemes(singletonList(apiKey()))
                .securityContexts(singletonList(securityContext()))
                .enableUrlTemplating(true)
                .globalRequestParameters(
                        singletonList(new springfox.documentation.builders.RequestParameterBuilder()
                                .name("someGlobalParameter")
                                .description("Description of someGlobalParameter")
                                .in(ParameterType.QUERY)
                                .required(true)
                                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                                .build()))
    
                // Adding tags is a way to define all the available tags that services/operations can opt into.
                // Currently this only has name and description.
                .tags(new Tag("Pet Service", "All apis relating to pets"))
                
                // Are there models in the application that are not "reachable"? Not reachable is when we have
                // models that we would like to be described but aren’t explicitly used in any operation.
                // An example of this is an operation that returns a model serialized as a string.
                // We do want to communicate the expectation of the schema for the string. This is a way to do
                // exactly that.
                // .additionalModels(typeResolver.resolve(AdditionalModel.class))
                
                ;
    }
    
    private ApiKey apiKey() {
        return new ApiKey("mykey", "api_key", "header");
    }
    
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/anyPath.*"))
                .build();
    }
    
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope =
                new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return singletonList(new SecurityReference("mykey", authorizationScopes));
    }
    
    @Bean
    SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .clientId("test-app-client-id")
                .clientSecret("test-app-client-secret")
                .realm("test-app-realm")
                .appName("test-app")
                .scopeSeparator(",")
                .additionalQueryStringParams(null)
                .useBasicAuthenticationWithAccessCodeGrant(false)
                .enableCsrfSupport(false)
                .build();
    }
    
    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .showCommonExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build();
    }
    
}
