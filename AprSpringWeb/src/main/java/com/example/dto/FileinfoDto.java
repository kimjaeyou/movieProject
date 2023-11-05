package com.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileinfoDto {
	private int fileid;
	private String name;
	private String path;
	private long filesize;
	private String description;
}
