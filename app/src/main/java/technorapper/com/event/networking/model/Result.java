
package technorapper.com.event.networking.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("relevance")
    @Expose
    private Integer relevance;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("labels")
    @Expose
    private List<String> labels = null;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("local_rank")
    @Expose
    private Integer localRank;
    @SerializedName("entities")
    @Expose
    private List<Entity> entities = null;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("end")
    @Expose
    private String end;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("first_seen")
    @Expose
    private String firstSeen;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("location")
    @Expose
    private List<Double> location = null;
    @SerializedName("scope")
    @Expose
    private String scope;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("place_hierarchies")
    @Expose
    private List<List<String>> placeHierarchies = null;
    @SerializedName("state")
    @Expose
    private String state;

    public Integer getRelevance() {
        return relevance;
    }

    public void setRelevance(Integer relevance) {
        this.relevance = relevance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getLocalRank() {
        return localRank;
    }

    public void setLocalRank(Integer localRank) {
        this.localRank = localRank;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(String firstSeen) {
        this.firstSeen = firstSeen;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<List<String>> getPlaceHierarchies() {
        return placeHierarchies;
    }

    public void setPlaceHierarchies(List<List<String>> placeHierarchies) {
        this.placeHierarchies = placeHierarchies;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
