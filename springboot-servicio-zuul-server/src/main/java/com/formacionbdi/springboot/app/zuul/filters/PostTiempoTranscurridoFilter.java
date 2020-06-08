package com.formacionbdi.springboot.app.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);
    @Override
    public String filterType() {
        // Va a ocurrir en el evento Post - antes de que se resuelva la ruta
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        // se usa para validar
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // Se define la logica de nuestro filtro
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request  enrutado a %s", request.getMethod(), request.getRequestURL().toString()));

        Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
        Long tiempoFinal = System.currentTimeMillis();
        Long tiempoTranscurrido = tiempoFinal - tiempoInicio;

        log.info(String.format("Tiempo transcurrido en segundos %s seg.", tiempoTranscurrido.doubleValue()/1000.00));
        log.info(String.format("Tiempo transcurrido en segundos %s ms.", tiempoTranscurrido.doubleValue()));

        return null;
    }
}
