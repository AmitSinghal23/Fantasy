package org.game.fantasy.quest.launcher;

import org.game.fantasy.quest.util.marshaller.MarshalStoreValidator;

/**
 * Hello world!
 *
 */
public class Launcher 
{
    public static void main( String[] args )
    {
    	MarshalStoreValidator validator = new MarshalStoreValidator();
    	try{
        	validator.validate();
            LauncherWorker worker = new LauncherWorker();
            worker.init();
    	}catch(IllegalArgumentException e){
    		System.err.println(e.getMessage());
    	}
    }


}
