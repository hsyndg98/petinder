package tr.edu.ege.petinder.userservice.util;

import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;

public class Mapper {
    protected static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    public static <T> T map(Object object, Class<T> destinationType) {
        return modelMapper.map(object, destinationType);
    }

}
