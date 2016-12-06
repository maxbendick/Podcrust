package audiosearch.util;

import audiosearch.model.JsonConverter;
import retrofit2.Converter;

import java.io.UnsupportedEncodingException;

import static audiosearch.model.JsonConverter.Gson;
import static audiosearch.model.JsonConverter.Jackson;
import static audiosearch.model.JsonConverter.Moshi;
import static audiosearch.model.JsonConverter.Protobuf;
import static audiosearch.model.JsonConverter.Wire;

public class HttpUtil {

    public static Converter.Factory getJsonConverter(JsonConverter jsonConverter){
        Converter.Factory converter = null;
        switch (jsonConverter){
            case Gson:
                converter = null;
                break;
            case Jackson:
                converter = null;
                break;
            case Moshi:
                converter = null;
                break;
            case Protobuf:
                converter = null;
                break;
            case Wire:
                converter = null;
                break;
            case SimpleXML:
                converter = null;
                break;
        }

        return converter;
    }

    public static String getSignature(String applicationId, String secret) throws UnsupportedEncodingException{
        String unencoded = applicationId+":"+ secret;
        String signature = Base64Encode.encode(unencoded).replaceAll("(\\r|\\n)", "");
        return signature;
    }
    
}
