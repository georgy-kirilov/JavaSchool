package solutions;

public interface TinyFunc<Tin, Tout> 
{
	Tout invoke(Tin argument);
}
