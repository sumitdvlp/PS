package Guitar_Design;

import Guitar_Design.Specs.GuitarSpec;
import Guitar_Design.Specs.InstrumentSpec;
import Guitar_Design.Specs.MandolinSpec;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by star on 10/25/18.
 */
public class Inventory {
    List<Instrument> instruments;

    public Inventory() {

    }
    public void addInstruments(InstrumentSpec instrumentSpec, String serialNumber, double price){

        Instrument instrument = null;

        if(instrumentSpec instanceof GuitarSpec){
            instrument = new Guitar(serialNumber,price, (GuitarSpec) instrumentSpec);
        }else if(instrumentSpec instanceof MandolinSpec){
            instrument = new Mandolin(serialNumber,price,(MandolinSpec) instrumentSpec);
        }
        instruments.add(instrument);

    }

    public Instrument getInstrument(String serialNumber){
        for (Iterator<Instrument> it = instruments.iterator(); it.hasNext(); ) {
            Instrument instrument = it.next();
            if(instrument.serialNumber.equals(serialNumber)){
                return instrument;
            }
        }
        return null;
    }

    public List<Instrument> search(InstrumentSpec searchSpec){

        List<Instrument> ret = new LinkedList<>();

        for(Iterator<Instrument> it = instruments.iterator(); it.hasNext();){
            Instrument instrument = it.next();
//            if(instrument.instrumentSpec instanceof GuitarSpec && instrumentSpec instanceof GuitarSpec && instrument.instrumentSpec.matches(instrumentSpec)){
//                ret.add(instrument);
//            }else if(instrument.instrumentSpec instanceof MandolinSpec && instrumentSpec instanceof MandolinSpec && instrument.instrumentSpec.matches(instrumentSpec)){
//                ret.add(instrument);
//            }
            if(instrument.getSpec().matches(searchSpec)){
                ret.add(instrument);
            }
        }
        return ret;
    }

}