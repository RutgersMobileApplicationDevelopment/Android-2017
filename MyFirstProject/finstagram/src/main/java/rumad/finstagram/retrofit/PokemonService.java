package rumad.finstagram.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hemanth on 11/1/17.
 */

public interface PokemonService {
    @GET("pokemon/1/")
    Call<ResponseBody> getPokemon();

}
