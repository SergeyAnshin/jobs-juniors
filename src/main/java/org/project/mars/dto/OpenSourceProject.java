package org.project.mars.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class OpenSourceProject {
    private String name;
    private String description;
    private String stack;
    private String link;
}
