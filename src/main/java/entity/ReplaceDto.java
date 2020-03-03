package entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ReplaceDto {
	
	@NonNull
	private String original;
	@NonNull
	private String target;

}
