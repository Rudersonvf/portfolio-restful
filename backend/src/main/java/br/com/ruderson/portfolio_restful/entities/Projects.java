package br.com.ruderson.portfolio_restful.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String description;
    private String githubUrl;
    private String liveUrl;
    private Set<String> imgPath;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "tb_project_category",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "tb_project_skill",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills = new HashSet<>();

}
