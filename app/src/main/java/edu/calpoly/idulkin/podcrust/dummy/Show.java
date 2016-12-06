package edu.calpoly.idulkin.podcrust.dummy;
// This is a hard coded test to show results
// Will be only implemented in Master-Detail View

/**
 * Created by Jonathan Chianglin on 12/1/2016.
 */

public class Show {
    private String title;
    private String image;
    private dummyEpisode[] list = new dummyEpisode[10];

    public Show() {
        this.title = "Rotoworld Fantasy Basketball Podcast";
        this.image = "https://www.audiosear.ch/media/ecfbb463b05ba9904c293b1d9f40adcd/0/public/image_file/106790/600x600bb.jpg";
        populateList();
    }

    private void populateList() {
        String[] episodeTitleList = {
                "Olympic Basketball Preview",
                "Olympic Basketball Pod for August 10",
                "Fantasy Basketball Podcast for Nov. 4",
                "Season Long Fantasy Hoops Podcast for Nov. 21",
                "Preseason Opener Pod",
                "Weekend Recap Podcast",
                "Lakers Preview Podcast",
                "Auction Fantasy Draft Strategy Podcast Part 1",
                "Eastern Conference Rookie Podcast",
                "Western Conference Rookie Podcast"
        };
        String[] descriptionList = {
                "Mike Gallagher and Steve Alexander take a look at some players to watch in Rio this month. Some tangents on fantasy and other stuff, too.",
                "Talking all things Olympic hoops and what it could mean for next season. Lots and lots of Dario Saric.\\n\\nApologies for the audio being off a little for this episode. Had some technical difficulties. It'll be better on Friday!",
                "Mike Gallagher and Steve Alexander break down Friday's DFS Slate. No James Harden, Russell Westbrook or most of the non-Anthony Davis superstars, so there's some money to go around tonight. We'll take a look at all the values and what higher-priced guys to target.",
                "We're talking some Pelicans, Nuggets, Suns, Celtics, Heat guards &amp; other murky rotations right now. Also we hit your questions.",
                "NBA BACK! Mike Gallagher goes over the Saturday action with some fantasy takeaways for DFS, Dynasty, season-long leagues and a lot more.",
                "Instead of drafting Patrick McCaw, the Bucks traded away Michael Carter-Williams for Tony Snell. We'll talk about that and how Matthew Dellavedova can step up.\\n\\nWe'll also talk about my boy Myles Turner and other big games.\\n\\nWe'll catch ya Wednesday!",
                "We lucked out to get Mike Trudell on this podcast. No explanation needed here. If you like basketball, you have to check this out.",
                "Auctions are great and one of my favorite topics. We'll do a two-part series here to talk about some overall strategy, some targets and a few other things to think about.\\n\\nWe talk about the difference between football and basketball auctions a lot here.\\n\\nWe'll be back on Monday for the second part!",
                "After Ben Simmons, it gets a little messy in the Eastern Conference. We'll cover all the rookies for DFS and especially season-long leagues.\\n\\nWe'll tackle some injuries and guys to keep an eye on for Dynasty leagues.\\n\\nWestern Conference is coming on Wednesday!\\n\\nHere's the Eastern Conference pod:",
                "The top 10 was loaded with Western Conference picks, but some are really, really raw. We'll go over what guys are worth targeting for Dynasty and redraft.\\n\\nPlus, a quick talk on Orlando Pro Summer League and some fun names.\\n\\nGet ready for a fun July"
        };
        String[] mp3List = {
                "https://www.audiosear.ch/media/bae18bcdd6354e663b6844e1effc5ee3/0/public/audio_file/158056/4903289-olympic-basketball-preview.mp3",
                "https://www.audiosear.ch/media/dc4fdff6355b21dd120b9cc55862d79f/0/public/audio_file/162684/4920560-olympic-basketball-pod-for-august-10.mp3",
                "https://www.audiosear.ch/media/a3d5c3f27708a902954a8e0cf352dcf1/0/public/audio_file/249798/5246635-fantasy-basketball-podcast-for-nov-4.mp3",
                "https://www.audiosear.ch/media/474520c0c969dcce59ee4cccb0bb707d/0/public/audio_file/267359/5310685-season-long-fantasy-hoops-podcast-for-nov-21.mp3",
                "https://www.audiosear.ch/media/5ef3e68be066e315227fbb910470adb6/0/public/audio_file/214409/5117380-preseason-opener-pod.mp3",
                "https://www.audiosear.ch/media/7dd69c5c22d53c141e0ea497c170e83e/0/public/audio_file/230460/5173772-weekend-recap-podcast.mp3",
                "https://www.audiosear.ch/media/58e05b663c295ba577976d4b6439b91d/0/public/audio_file/210116/5101311-lakers-preview-podcast.mp3",
                "https://www.audiosear.ch/media/3928df8097ffe906dafd0d047690117d/0/public/audio_file/192342/5030677-auction-fantasy-draft-strategy-podcast-part-1.mp3",
                "https://www.audiosear.ch/media/8e14439fd928a6c6cad74ca8daa38516/0/public/audio_file/117751/4754131-eastern-conference-rookie-podcast.mp3",
                "https://www.audiosear.ch/media/38d8b5148adc315d512bbcf221b3abd2/0/public/audio_file/120294/4763485-western-conference-rookie-preview-podcast.mp3"
        };
        for (int i = 0; i < list.length; i++) {
            list[i] = new dummyEpisode(episodeTitleList[i], descriptionList[i], mp3List[i]);
        }

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public dummyEpisode[] getList() {
        return list;
    }

    public void setList(dummyEpisode[] list) {
        this.list = list;
    }

    public class dummyEpisode {
        private String episodeTitle;
        private String description;
        private String mp3;

        public dummyEpisode(String episodeTitle, String description, String mp3) {
            this.episodeTitle = episodeTitle;
            this.description = description;
            this.mp3 = mp3;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMp3() {
            return mp3;
        }

        public void setMp3(String mp3) {
            this.mp3 = mp3;
        }

        public String getEpisodeTitle() {
            return episodeTitle;
        }

        public void setEpisodeTitle(String episodeTitle) {
            this.episodeTitle = episodeTitle;
        }
    }

}
