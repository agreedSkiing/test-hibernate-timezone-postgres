package org.acme.endpoints;

import static org.acme.to.json.Output.Builder;

import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("time")
@ApplicationScoped
public class Time {

  @Inject
  org.acme.repositories.Time repo;

  @GET
  public Response preset() {
    return Response
      .ok(
        new Builder()
          .withTimezoneField(
            ZonedDateTime
              .parse(
                "2022-12-18T19:39:20+01:00",
                DateTimeFormatter.ISO_OFFSET_DATE_TIME
              )
              .toString()
          )
          .withoutTimezoneField(
            LocalDateTime
              .parse(
                "2022-12-18T19:39:20Z",
                DateTimeFormatter.ISO_OFFSET_DATE_TIME
              )
              .toString()
          )
          .withTimezoneGmt2Field(
            Instant.parse("2022-12-18T19:39:20+02:00").toString()
          )
          .build()
      )
      .build();
  }

  @GET
  @Path("instants")
  public Response instants() {
    var entity = repo.getAsInstants();
    return Response
      .ok(
        new Builder()
          .withTimezoneField(entity.withTimeZone.toString())
          .withTimezoneGmt2Field(entity.withTimeZoneGmt2.toString())
          .withoutTimezoneField(entity.noTimeZone.toString())
          .build()
      )
      .build();
  }

  @GET
  @Path("localdatetimes")
  public Response localdatetimes() {
    var entity = repo.getAsLocalDateTimes();
    return Response
      .ok(
        new Builder()
          .withTimezoneField(entity.withTimeZone.toString())
          .withTimezoneGmt2Field(entity.withTimeZoneGmt2.toString())
          .withoutTimezoneField(entity.noTimeZone.toString())
          .build()
      )
      .build();
  }

  @GET
  @Path("offsetdatetimes")
  public Response offsetdatetimes() {
    var entity = repo.getAsOffsetDateTimes();
    return Response
      .ok(
        new Builder()
          .withTimezoneField(entity.withTimeZone.toString())
          .withTimezoneGmt2Field(entity.withTimeZoneGmt2.toString())
          .withoutTimezoneField(entity.noTimeZone.toString())
          .build()
      )
      .build();
  }

  @GET
  @Path("zoneddatetimes")
  public Response zoneddatetimes() {
    var entity = repo.getAsZonedDateTimes();
    return Response
      .ok(
        new Builder()
          .withTimezoneField(entity.withTimeZone.toString())
          .withTimezoneGmt2Field(entity.withTimeZoneGmt2.toString())
          .withoutTimezoneField(entity.noTimeZone.toString())
          .build()
      )
      .build();
  }

  @POST
  @Path("instants")
  public Response createInstants() {
    var entity = repo.createInstants();
    return Response
      .ok(
        new Builder()
          .withTimezoneField(entity.withTimeZone.toString())
          .withTimezoneGmt2Field(entity.withTimeZoneGmt2.toString())
          .withoutTimezoneField(entity.noTimeZone.toString())
          .build()
      )
      .build();
  }

  @POST
  @Path("localdatetimes")
  public Response createLocaldatetimes() {
    var entity = repo.createLocalDateTimes();
    return Response
      .ok(
        new Builder()
          .withTimezoneField(entity.withTimeZone.toString())
          .withTimezoneGmt2Field(entity.withTimeZoneGmt2.toString())
          .withoutTimezoneField(entity.noTimeZone.toString())
          .build()
      )
      .build();
  }

  @POST
  @Path("offsetdatetimes")
  public Response createOffsetdatetimes() {
    var entity = repo.createOffsetDateTimes();
    return Response
      .ok(
        new Builder()
          .withTimezoneField(entity.withTimeZone.toString())
          .withTimezoneGmt2Field(entity.withTimeZoneGmt2.toString())
          .withoutTimezoneField(entity.noTimeZone.toString())
          .build()
      )
      .build();
  }

  @POST
  @Path("zoneddatetimes")
  public Response createZoneddatetimes() {
    var entity = repo.createZonedDateTimes();
    return Response
      .ok(
        new Builder()
          .withTimezoneField(entity.withTimeZone.toString())
          .withTimezoneGmt2Field(entity.withTimeZoneGmt2.toString())
          .withoutTimezoneField(entity.noTimeZone.toString())
          .build()
      )
      .build();
  }
}
