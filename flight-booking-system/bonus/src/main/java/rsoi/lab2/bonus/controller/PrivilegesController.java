package rsoi.lab2.bonus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rsoi.lab2.bonus.responses.PrivilegeResponse;
import rsoi.lab2.bonus.usecases.FindPrivilegeUseCase;

@RestController
@RequestMapping("/api/v1/privilege")
public class PrivilegesController {

    private final FindPrivilegeUseCase findPrivilegeUseCase;

    public PrivilegesController(FindPrivilegeUseCase findPrivilegeUseCase) {
        this.findPrivilegeUseCase = findPrivilegeUseCase;
    }

    @GetMapping()
    public ResponseEntity<PrivilegeResponse> getPrivilege() {
        return ResponseEntity.ok(findPrivilegeUseCase.execute());
    }
}
