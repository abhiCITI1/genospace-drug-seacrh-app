package com.genospace.genospace.controller;


import com.genospace.genospace.models.*;
import com.genospace.genospace.services.DrugSearchService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class DrugSearchController implements InitializingBean{


    @Autowired
    private DrugSearchService drugSearchService;


    private List<String> drugList;

    private List<String> mechanismList;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String sayHello()
    {
        return "drugs";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchDrug")
    public @ResponseBody  JSONArray suggestDrugOrMechanism(Model model, @RequestParam(value="item", required=true) String drugItem)
    {

        List<Drug> drugs = drugSearchService.findDrugs();

        List<Mechanism> mechanisms = drugSearchService.findMechanisms();

        JSONArray arr = new JSONArray();

        for (Drug drug:
             drugs  ) {
            String drugName = drug.getDrugName();

            JSONObject drugObject = new JSONObject();

            if(drugName.toLowerCase().startsWith(drugItem.toLowerCase()) && drugItem!="")
            {
                drugObject.put("drug" , drugName);
                arr.add(drugObject);
            }

        }

        for (Mechanism mechanism:
                mechanisms  ) {
            String mechName = mechanism.getMechanismName();

            JSONObject mechanismObject = new JSONObject();

            if(mechName!=null)
            {

                if(mechName.toLowerCase().startsWith(drugItem.toLowerCase()) && drugItem!="")
                {
                    mechanismObject.put("mechanism" , mechName);
                    arr.add(mechanismObject);
                }
            }


        }


        model.addAttribute("drugList", arr);

        return arr;
    }



    @RequestMapping(method = RequestMethod.POST, value = "/searchDrug")
    public String searchDrugOrMechanism(Model model, @RequestParam(value="item", required=true) String drugItem)
    {
        if(drugList.contains(drugItem))
        {
            List<Drug> drugs = drugSearchService.findDrugs();

            JSONObject drugObject = new JSONObject();

            Drug foundDrug = null;

            for (Drug drug: drugs) {
                if(drug.getDrugName().toLowerCase().equalsIgnoreCase(drugItem.toLowerCase()))
                {
                    foundDrug = drug;
                    break;
                }
            }

            if(foundDrug!=null)
            {

                drugObject.put("DrugName", foundDrug.getDrugName());
                List<NamesCode> namesCodes = foundDrug.getNamesCodes();

                JSONArray namesCodeArr = new JSONArray();

                for (NamesCode nameCode: namesCodes) {
                    JSONObject nameCodeObj = new JSONObject();
                    nameCodeObj.put("NameCode" , nameCode.getName());
                    namesCodeArr.add(nameCodeObj);
                }

                drugObject.put("NamesCode", namesCodeArr);

                List<NamesBrand> namesBrands = foundDrug.getNamesBrands();

                JSONArray namesBrandArr = new JSONArray();

                for (NamesBrand nameBrand: namesBrands) {
                    JSONObject nameBrandObj = new JSONObject();
                    nameBrandObj.put("NameBrand", nameBrand.getName());
                    namesBrandArr.add(nameBrandObj);
                }

                drugObject.put("NamesBrand", namesBrandArr);

                List<NamesGeneric> namesGeneric = foundDrug.getNamesGenerics();

                JSONArray namesGenericArr = new JSONArray();

                for (NamesGeneric nameGeneric: namesGeneric) {
                    JSONObject nameGenericObj = new JSONObject();
                    nameGenericObj.put("NameGeneric", nameGeneric.getName());
                    namesGenericArr.add(nameGenericObj);
                }

                drugObject.put("NamesGeneric", namesGenericArr);

                List<MechanismMolecular> mechanismMoleculars = foundDrug.getMechanismMoleculars();

                JSONArray mechMolecularArr = new JSONArray();

                for (MechanismMolecular mechMolecular: mechanismMoleculars) {
                    JSONObject mechMolObj = new JSONObject();
                    mechMolObj.put("Mechanism", mechMolecular.getMechanismName());
                    mechMolecularArr.add(mechMolObj);
                }

                drugObject.put("MechanismsMolecular", mechMolecularArr);

                List<DevelopmentStatusSummaryRow> rows = foundDrug.getDevelopmentStatusSummaryRows();

                JSONArray rowArr = new JSONArray();

                for (DevelopmentStatusSummaryRow row: rows) {

                    JSONObject rowObj = new JSONObject();

                    rowObj.put("Condition", row.getConditionName());
                    rowObj.put("PhaseHighest", row.getPhaseHighest());
                    rowObj.put("ConditionInActiveDevelopment", row.isConditionInActiveDevelopment());
                    rowObj.put("Year", row.getYear());

                    List<Organization> organizations = row.getOrganizations();

                    JSONArray organizationArr = new JSONArray();

                    for (Organization organization: organizations) {
                        JSONObject orgObj = new JSONObject();
                        orgObj.put("OrganizationName", organization.getOrganizationName());
                        organizationArr.add(orgObj);
                    }

                    rowObj.put("Organizations", organizationArr);

                    List<AdministrationRoute> routes = row.getAdministrationRoutes();

                    JSONArray routeArr = new JSONArray();

                    for (AdministrationRoute route: routes) {
                        JSONObject routeObj = new JSONObject();
                        routeObj.put("AdministrationRouteName", route.getAdministrativeRouteName());
                        routeArr.add(routeObj);
                    }

                    rowObj.put("AdministrationRoutes",routeArr);

                    rowArr.add(rowObj);
                }

                drugObject.put("DevelopmentStatusSummary", rowArr);

                model.addAttribute("DrugSummary", drugObject);

                return "drug_summary";
            }



        }


        if(mechanismList.contains(drugItem))
        {
            List<Mechanism> mechanisms = drugSearchService.findMechanisms();

            List<String> associatedDrugList = new ArrayList<>();
            for (Mechanism mechanism: mechanisms) {
                if(mechanism.getMechanismName().equalsIgnoreCase(drugItem))
                {
                    model.addAttribute("mechanismName" , mechanism.getMechanismName());
                    List<Drug> mechDrugs = mechanism.getDrugs();

                    for (Drug drug: mechDrugs) {
                        associatedDrugList.add(drug.getDrugName());
                    }
                    model.addAttribute("associatedDrugList" , associatedDrugList);
                    break;
                }
            }

            return "mechanisms";
        }

        return "error";
    }


    @Override
    public void afterPropertiesSet() throws Exception {

        drugList = new ArrayList<>();
        mechanismList = new ArrayList<>();

        List<Drug> drugs = drugSearchService.findDrugs();

        List<Mechanism> mechanisms = drugSearchService.findMechanisms();


        for (Drug drug: drugs) {
            drugList.add(drug.getDrugName());
        }

        for (Mechanism mechanism: mechanisms) {
            mechanismList.add(mechanism.getMechanismName());
        }


    }
}
