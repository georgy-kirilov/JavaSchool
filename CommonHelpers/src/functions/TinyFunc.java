package functions;

public interface TinyFunc<T, Tout> 
{
	Tout invoke(T argument);
}
