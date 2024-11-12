package Rali.SportsCenter.repos.Booking;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

import Rali.SportsCenter.repos.Order.OrderDataModel;
import Rali.SportsCenter.repos.Team.TeamDataModel;
import Rali.SportsCenter.repos.Venue.VenueDataModel;

@Entity
@Table(name = "Booking")
public class BookingDataModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    
    private LocalDateTime date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "teamId")
    private TeamDataModel team;

    @ManyToOne
    @JoinColumn(name = "venueId")
    private VenueDataModel venue;

    @ManyToMany
    @JoinTable(
        name = "Booking-Order",
        joinColumns = @JoinColumn(name = "bookingId"),
        inverseJoinColumns = @JoinColumn (name = "orderId")
    
    )
    private Set<OrderDataModel> orders;

    // No-argument constructor
    public BookingDataModel() {}

    // Parameterized constructor
    public BookingDataModel(LocalDateTime date, LocalDateTime startTime, LocalDateTime endTime, TeamDataModel team, VenueDataModel venue) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.team = team;
        this.venue = venue;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public TeamDataModel getTeam() {
        return team;
    }

    public void setTeam(TeamDataModel team) {
        this.team = team;
    }

    public VenueDataModel getVenue() {
        return venue;
    }

    public void setVenue(VenueDataModel venue) {
        this.venue = venue;
    }

    // Getters and Setters
}
