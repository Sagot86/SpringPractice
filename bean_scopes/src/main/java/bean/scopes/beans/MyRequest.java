package bean.scopes.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = TARGET_CLASS)
@NoArgsConstructor
@Setter
@Getter
public class MyRequest {

    private String param;
}
