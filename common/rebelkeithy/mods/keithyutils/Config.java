package rebelkeithy.mods.keithyutils;

import java.io.File;

import net.minecraftforge.common.Configuration;

public abstract class Config 
{
	
	public void init(File file)
	{
		Configuration config = new Configuration(file);
		config.load();

		initValues(config);
		
		config.save();
	}
	
	protected abstract void initValues(Configuration config);
}
