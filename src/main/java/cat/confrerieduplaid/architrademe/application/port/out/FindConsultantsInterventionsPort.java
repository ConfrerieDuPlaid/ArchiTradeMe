package cat.confrerieduplaid.architrademe.application.port.out;

import cat.confrerieduplaid.architrademe.domain.ConsultantId;
import cat.confrerieduplaid.architrademe.domain.Intervention;

import java.util.List;

public interface FindConsultantsInterventionsPort {
    List<Intervention> find(ConsultantId consultantId);
}
