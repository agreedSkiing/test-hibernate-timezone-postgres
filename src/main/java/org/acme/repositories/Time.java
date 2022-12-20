package org.acme.repositories;

import java.time.format.DateTimeFormatter;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.acme.entities.Instant;
import org.acme.entities.LocalDateTime;
import org.acme.entities.OffsetDateTime;
import org.acme.entities.ZonedDateTime;

@ApplicationScoped
public class Time {

  @Inject
  EntityManager em;

  public Instant getAsInstants() {
    return em.find(Instant.class, 1);
  }

  public LocalDateTime getAsLocalDateTimes() {
    return em.find(LocalDateTime.class, 1);
  }

  public OffsetDateTime getAsOffsetDateTimes() {
    return em.find(OffsetDateTime.class, 1);
  }

  public ZonedDateTime getAsZonedDateTimes() {
    return em.find(ZonedDateTime.class, 1);
  }

  @Transactional
  public Instant createInstants() {
    var entity = new Instant();
    entity.noTimeZone = java.time.Instant.parse("2022-12-20T20:24:00+01:00");
    entity.withTimeZone = java.time.Instant.parse("2022-12-20T20:24:00+01:00");
    entity.withTimeZoneGmt2 =
      java.time.Instant.parse("2022-12-20T20:24:00+02:00");
    em.persist(entity);
    return entity;
  }

  @Transactional
  public LocalDateTime createLocalDateTimes() {
    var entity = new LocalDateTime();
    entity.noTimeZone =
      java.time.LocalDateTime.parse(
        "2022-12-20T20:24:00+01:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    entity.withTimeZone =
      java.time.LocalDateTime.parse(
        "2022-12-20T20:24:00+01:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    entity.withTimeZoneGmt2 =
      java.time.LocalDateTime.parse(
        "2022-12-20T20:24:00+02:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    em.persist(entity);
    return entity;
  }

  @Transactional
  public OffsetDateTime createOffsetDateTimes() {
    var entity = new OffsetDateTime();
    entity.noTimeZone =
      java.time.OffsetDateTime.parse(
        "2022-12-20T20:24:00+01:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    entity.withTimeZone =
      java.time.OffsetDateTime.parse(
        "2022-12-20T20:24:00+01:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    entity.withTimeZoneGmt2 =
      java.time.OffsetDateTime.parse(
        "2022-12-20T20:24:00+02:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    em.persist(entity);
    return entity;
  }

  @Transactional
  public ZonedDateTime createZonedDateTimes() {
    var entity = new ZonedDateTime();
    entity.noTimeZone =
      java.time.ZonedDateTime.parse(
        "2022-12-20T20:24:00+01:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    entity.withTimeZone =
      java.time.ZonedDateTime.parse(
        "2022-12-20T20:24:00+01:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    entity.withTimeZoneGmt2 =
      java.time.ZonedDateTime.parse(
        "2022-12-20T20:24:00+02:00",
        DateTimeFormatter.ISO_OFFSET_DATE_TIME
      );
    em.persist(entity);
    return entity;
  }
}
