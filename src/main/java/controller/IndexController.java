package controller;


import model.PersonModel;
import persistence.service.PersonService;
import persistence.service.PersonServiceImpl;

import javax.persistence.Index;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/index")
public class IndexController {

    /*@Path("hello")
    @GET
    public void sayHello(){

        System.out.println("Hello World");
    }*/

    /*@Path("/hello/{name}/{surname}")
    @GET
    public String sayHello(@PathParam("name") String ad, @PathParam("surname") String soyad){

        return "Hello " +ad+" "+soyad;*/


        /*@Path("/hello")
        @GET
        public String sayHello(@QueryParam("name") String ad, @QueryParam("surname") String soyad){
            return "Hello" +ad+" " +soyad;
        }*/


       /* @Path("/hello")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public PersonModel sayHello(){

            PersonModel person = new PersonModel();
            person.setId(1);
            person.setName("Mecid");
            person.setSurname("Mecidov");

            return person; //new PersonModel(1000,"Eyyub","Qedirov");
        }*/

      /*  @Path("/hello")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public PersonModel sayHello(@QueryParam("id") Integer id){

            return new PersonModel(id,"Eyyub","Qedirov");

        }*/

    private PersonService personService = new PersonServiceImpl();

    @Path("/")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonModel> getAllPersons(){


        return personService.getAllPersons();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})

    public void add(PersonModel model){

        personService.addPerson(model);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void update(PersonModel model){

        personService.updatePerson(model);

    }

    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") Integer id){

        personService.deletePerson(id);
    }



    }

