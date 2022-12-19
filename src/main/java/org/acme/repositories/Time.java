package org.acme.repositories;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.acme.entities.*;

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
}
