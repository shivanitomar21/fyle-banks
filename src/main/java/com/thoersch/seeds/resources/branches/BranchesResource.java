package com.thoersch.seeds.resources.branches;

import com.thoersch.seeds.persistence.branches.BranchesRepository;
import com.thoersch.seeds.representations.branches.Branches;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/branches")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class BranchesResource {

    private final BranchesRepository branchesRepository;

    @Inject
    public BranchesResource(BranchesRepository branchesRepository) {
        this.branchesRepository = branchesRepository;
    }

    @GET
    public List<Branches> getBranches() {
        return branchesRepository.findAll();
    }

    @RequestMapping(value="/code")
    public Branches getBranches(@RequestParam(value="ifsc") String bankIfsc) {

    	System.out.print("^^^^^^^^^^^^^^^^^^&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    	System.out.print(bankIfsc);
        Branches branches = branchesRepository.findBranchByIfsc(bankIfsc);

        if(branches == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return branches;
    }
    

//    @POST
//    public Branches saveBranches(@Valid Branches branches) {
//        return branchesRepository.save(banks);
//    }
//
    
    
    
    
//    @DELETE
//    @Path("/{id}")
//    public void deleteBranches(@PathParam("id") long id) {
//        branchesRepository.delete(id);
//    }
}
