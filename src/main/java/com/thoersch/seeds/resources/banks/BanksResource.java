package com.thoersch.seeds.resources.banks;

import com.thoersch.seeds.persistence.banks.BanksRepository;
import com.thoersch.seeds.representations.banks.Banks;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/banks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class BanksResource {

    private final BanksRepository banksRepository;

    @Inject
    public BanksResource(BanksRepository banksRepository) {
        this.banksRepository = banksRepository;
    }

    @GET
    public List<Banks> getBanks() {
        return banksRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public Banks getBanks(@PathParam("id") long id) {
    	System.out.print("$%^$%^$%#$%%^^#$%#$%^^$%#%%%#$#$$%#@$#%#@#$");
    	System.out.print(id);
    	System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        Banks banks = banksRepository.findOne(id);

        if(banks == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return banks;
    }

    @POST
    public Banks saveBanks(@Valid Banks banks) {
        return banksRepository.save(banks);
    }

    @DELETE
    @Path("/{id}")
    public void deleteBook(@PathParam("id") long id) {
        banksRepository.delete(id);
    }
}
