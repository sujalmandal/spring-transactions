package s.m.tx.common;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import s.m.tx.web.RequestContext;

import java.util.Optional;

@Component
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return RequestContext.getCurrentUser();
    }

}
