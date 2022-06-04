package apigateway;

import org.modelmapper.ModelMapper;

public class Mapper {

    protected static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    public static <T> T map(Object object, Class<T> destinationType) {
        return modelMapper.map(object, destinationType);
    }

}
