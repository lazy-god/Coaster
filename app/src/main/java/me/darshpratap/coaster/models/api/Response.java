package me.darshpratap.coaster.models.api;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("performance")
    private Performance performance;
    @SerializedName("accessibility")
    private Accessibilty accessibilty;
    @SerializedName("best-practices")
    private Best_Practices best_practices;
    @SerializedName("pwa")
    private Pwa pwa;
    @SerializedName("seo")
    private Seo seo;

    public Response(Performance performance, Accessibilty accessibilty, Best_Practices best_practices, Pwa pwa, Seo seo) {
        this.performance = performance;
        this.accessibilty = accessibilty;
        this.best_practices = best_practices;
        this.pwa = pwa;
        this.seo = seo;
    }

    public Performance getPerformance() {
        return performance;
    }

    public Accessibilty getAccessibilty() {
        return accessibilty;
    }

    public Best_Practices getBest_practices() {
        return best_practices;
    }

    public Pwa getPwa() {
        return pwa;
    }

    public Seo getSeo() {
        return seo;
    }
}
