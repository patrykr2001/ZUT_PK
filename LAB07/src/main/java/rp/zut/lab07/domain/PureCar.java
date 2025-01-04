package rp.zut.lab07.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class PureCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;
    private String registrationNumber;
    private String mark;
    private String name;
    private String type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private CarOwner owner;

//    @Override
//    public String toString() {
//        return "PureCar{" +
//                "carId=" + carId +
//                ", registrationNumber='" + registrationNumber + '\'' +
//                ", mark='" + mark + '\'' +
//                ", name='" + name + '\'' +
//                ", type='" + type + '\'' +
//                ", owner=" + owner +
//                '}';
//    }
}