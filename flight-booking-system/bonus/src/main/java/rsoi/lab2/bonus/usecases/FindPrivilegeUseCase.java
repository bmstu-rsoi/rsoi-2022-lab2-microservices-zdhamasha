package rsoi.lab2.bonus.usecases;

import org.springframework.stereotype.Component;
import rsoi.lab2.bonus.model.Privilege;
import rsoi.lab2.bonus.repositories.PrivilegeRepository;
import rsoi.lab2.bonus.responses.PrivilegeResponse;

@Component
public class FindPrivilegeUseCase {

    private final PrivilegeRepository privilegeRepository;

    public FindPrivilegeUseCase(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    public PrivilegeResponse execute() {
        return privilegeRepository.findAll()
                .stream()
                .findFirst()
                .map(this::mapToPrivilegeResponse)
                .orElseThrow(IllegalStateException::new);
    }

    private PrivilegeResponse mapToPrivilegeResponse(Privilege privilege) {
        PrivilegeResponse privilegeResponse = new PrivilegeResponse();

        privilegeResponse.setUsername(privilege.getUsername());
        privilegeResponse.setBalance(privilege.getBalance());
        privilegeResponse.setStatus(privilege.getStatus());

        return privilegeResponse;
    }
}
