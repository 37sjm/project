import models.Player;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * This stateless session bean serves as a RESTful resource handler for the CPDB.
 * It uses a container-managed entity manager.
 *
 * @author kvlinden
 * @version Spring, 2017
 */
@Stateless
@Path("project/")
public class PlayerResource {


    @PersistenceContext
    private EntityManager em;

    @GET
    @Path("hello")
    @Produces("text/plain")
    public String getClichedMessage() {
        return "Hello, JPA!";
    }

    @GET
    @Path("player/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayer(@PathParam("id") long id) {
        return em.find(Player.class, id);
    }

    @GET
    @Path("players")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> getPlayers() {
        return em.createQuery(em.getCriteriaBuilder().createQuery(Player.class)).getResultList();
    }

}