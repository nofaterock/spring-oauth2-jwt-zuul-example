package filters.pre

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException
import groovy.util.logging.Slf4j
import org.apache.commons.io.IOUtils

import javax.servlet.http.HttpServletRequest

@Slf4j
class SampleFilter extends ZuulFilter {
	@Override
	String filterType() {
		return 'pre'
	}

	@Override
	int filterOrder() {
		return 2
	}

	@Override
	boolean shouldFilter() {
		return true
	}

	@Override
	Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext()
		HttpServletRequest request = ctx.getRequest()

		log.info('{}\t{}', request.getMethod(), request.getRequestURL())

		return null
	}
}

