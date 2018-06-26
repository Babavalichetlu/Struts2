
package com.createsend.util.jersey;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

public class JsonProvider extends JacksonJsonProvider {

    public static final DateFormat ApiDateFormat = new SimpleDateFormat("yyyy-MM-dd") {
        final SimpleDateFormat ApiDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final SimpleDateFormat ApiDateFormatTz = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

        @Override
        public Date parse(String source, ParsePosition pos) {
            if (source.length() - pos.getIndex() == ApiDateFormat.toPattern().length())
                return ApiDateFormat.parse(source, pos);
            return ApiDateFormatTz.parse(source, pos);
        }
    };

    @Override
    public void writeTo(Object value, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) throws IOException {
        ObjectMapper mapper = locateMapper(type, mediaType);
        mapper.setSerializationInclusion(Inclusion.NON_NULL);
        
        super.writeTo(value, type, genericType, annotations, mediaType, httpHeaders,
                entityStream);
    }
    
    @Override
    public Object readFrom(Class<Object> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException {
        ObjectMapper mapper = locateMapper(type, mediaType);
        mapper.setDateFormat(ApiDateFormat);
        mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);

        return super.readFrom(type, genericType, annotations, mediaType, httpHeaders,
                entityStream);
    }
}
