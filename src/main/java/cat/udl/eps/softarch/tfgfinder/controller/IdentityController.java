package cat.udl.eps.softarch.tfgfinder.controller;

import cat.udl.eps.softarch.tfgfinder.domain.User;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@BasePathAwareController
public class IdentityController {

  @RequestMapping("/identity")
  public @ResponseBody
  PersistentEntityResource getAuthenticatedUserIdentity(
      PersistentEntityResourceAssembler resourceAssembler) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    return resourceAssembler.toFullResource(user);
  }
}
