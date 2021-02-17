package coolcollections;

import delegates.primitive.*;

public interface Sumable<TSource>
{
	/*long sum(ByteFunc<TSource> selector);
	
	long sum(ShortFunc<TSource> selector);*/
	
	/*long sum(IntegerFunc<TSource> selector);*/
	
	long sum(LongFunc<TSource> selector);
	
	double sum(FloatFunc<TSource> selector);
	
	/*double sum(DoubleFunc<TSource> selector);
	
	long sum(BooleanFunc<TSource> selector);
	
	long sum(CharacterFunc<TSource> selector);*/
}
