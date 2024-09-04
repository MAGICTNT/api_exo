package fr.maxime.api_exo.resource;

import fr.maxime.api_exo.entity.Voiture;
import fr.maxime.api_exo.service.Service;
import fr.maxime.api_exo.service.VoitureService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/voiture")
public class VoitureResource {
    private final Service voitureService;

    @Inject
    public VoitureResource(Service voitureService) {
        this.voitureService = voitureService;
    }

    @GET
    public List<Voiture> getAll() {
        return voitureService.getVoitureList();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        Voiture voiture = voitureService.getVoitureById(id);
        if (voiture != null) {
            return Response.ok(voiture).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response create(Voiture voiture) {
        try {
            Voiture createdVoiture = voitureService.addVoiture(voiture);
            return Response.status(Response.Status.CREATED).entity(createdVoiture).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Erreur lors de la création de la voiture : " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Voiture voiture) {
        if (voiture != null && id == voiture.getIdVoiture()) {
            try {
                Voiture updatedVoiture = voitureService.updateVoiture(id, voiture);
                return Response.ok(updatedVoiture).build();
            } catch (Exception e) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Erreur lors de la mise à jour de la voiture : " + e.getMessage()).build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            voitureService.removeVoiture(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Erreur lors de la suppression de la voiture : " + e.getMessage()).build();
        }
    }
}
