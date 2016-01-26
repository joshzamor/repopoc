package org.openlmis.repopoc.controller;

import lombok.NoArgsConstructor;
import org.openlmis.core.domain.FacilityType;
import org.openlmis.core.service.FacilityService;
import org.openlmis.restapi.controller.LookupController;
import org.openlmis.restapi.response.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@NoArgsConstructor
public class RepoPocController {

  @Autowired
  private FacilityService facilityService;

  /**
   * Returns all the facility types the system knows of.  This is an example that "extends" the API and documents the
   * changes needed to introduce a new module that can add API endpoints.  This method is left unsecured for demo
   * purposes.
   * @return all the facility types.
   */
  @RequestMapping(value = "/repo-poc/facilityTypes", method = RequestMethod.GET, headers = LookupController.ACCEPT_JSON)
  public ResponseEntity FacilityTypePrint() {
    List<FacilityType> types = facilityService.getAllTypes();
    return RestResponse.response("facility-types", types);
  }
}
