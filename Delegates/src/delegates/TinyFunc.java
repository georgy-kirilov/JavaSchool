package delegates;

public interface TinyFunc<T, Out> 
{
	Out invoke(T argument);
}
