package org.openstreetmap.sotmlatam.controller;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import org.openstreetmap.sotmlatam.R;
import org.openstreetmap.sotmlatam.utils.BaseOSMCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by laura on 9/8/2016.
 */
public class EventController {
    String place;
    Context context;
    List<BaseOSMCalendar> eventList;

    public EventController(String place, Context context) {
        this.place = place;
        this.context = context;
        eventList = new ArrayList<>();
    }

    public List<BaseOSMCalendar> getEventList(String param, String date) {
        switch (param) {
            case "Session 1":
                createEventsLocal1(date);
                break;
            case "Session 2":
                createEventsLocal2(date);
                break;
            default:
                createEventsLocal3(date);
        }

        return eventList;
    }

    private void createGenericsEvent() {
        Calendar startTime3 = new GregorianCalendar(2016, Calendar.SEPTEMBER, 23, 9, 0);
        Calendar endTime3 = new GregorianCalendar(2016, Calendar.SEPTEMBER, 23, 9, 0);

        BaseOSMCalendar event = new BaseOSMCalendar("8:00-Registration Coffee Tea",
                "", "Vrije Universiteit Brussel",
                ContextCompat.getColor(context,
                          android.R.color.holo_red_light), startTime3,
                endTime3, "");
        eventList.add(event);

        Calendar start2 = new GregorianCalendar(2016, Calendar.SEPTEMBER, 23, 9, 0);

        Calendar end2 = new GregorianCalendar(2016, Calendar.SEPTEMBER, 23, 9, 29);

        BaseOSMCalendar event2 = new BaseOSMCalendar("9:00-Opening Session VUB Building Q",
                "", "Vrije Universiteit Brussel",
                ContextCompat.getColor(context,
                          android.R.color.holo_red_light), start2,
                end2, "");
        eventList.add(event2);

        Calendar start3 = new GregorianCalendar(2016, Calendar.SEPTEMBER, 23, 9, 30);

        Calendar end3 = new GregorianCalendar(2016, Calendar.SEPTEMBER, 23, 9, 59);

        BaseOSMCalendar event3 = new BaseOSMCalendar("9:30-Keynote Ambassador Allan Mustard VUB Building Q",
                "", "Vrije Universiteit Brussel",
                ContextCompat.getColor(context,
                        android.R.color.holo_red_light), start2,
                end2, true, "");
        eventList.add(event3);
    }

    private void createEventsLocal3(String day) {
        if (day.equals("Day 23")) {
            createGenericsEvent();
            createEvent(Calendar.SEPTEMBER, 23, 10, 0, 10, 59, "10:00-Birds of a feather", "", R.color.oyellow, "Building D/Room 1+2", "\n" +
                    "\n" +
                    "On Friday, Saturday and Sunday of State of the Map, we will have several spaces for informal “Birds of a Feather” (BoFs). These are informal get meetings, planned ahead or thought up spontaneously. Discussions, mapping, code and documentation sprints, and hacking sessions, whatever you want! The sessions will take place in the Foyer and “Building D” classrooms, adjacent to the main conference hall. We will have a sign up board prominently in the main area to schedule sessions and add ideas.\n" +
                    "\n" +
                    "For now, start to share and discuss your ideas by posting them on http://wiki.openstreetmap.org/wiki/State_Of_The_Map_2016/Informal_Sessions#Birds_of_a_Feather_Sessions\n");
            createEvent(Calendar.SEPTEMBER, 23, 11, 0, 11, 29, "11:00-Coffee/Tea", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 23, 11, 30, 12, 59, "11:30-Birds of a feather", "", R.color.oyellow, "Building D/Room 1+2", "\n" +
                    "\n" +
                    "On Friday, Saturday and Sunday of State of the Map, we will have several spaces for informal “Birds of a Feather” (BoFs). These are informal get meetings, planned ahead or thought up spontaneously. Discussions, mapping, code and documentation sprints, and hacking sessions, whatever you want! The sessions will take place in the Foyer and “Building D” classrooms, adjacent to the main conference hall. We will have a sign up board prominently in the main area to schedule sessions and add ideas.\n" +
                    "\n" +
                    "For now, start to share and discuss your ideas by posting them on http://wiki.openstreetmap.org/wiki/State_Of_The_Map_2016/Informal_Sessions#Birds_of_a_Feather_Sessions\n");
            createEvent(Calendar.SEPTEMBER, 23, 13, 0, 13, 49, "1:00-Lunch", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 23, 13, 50, 14, 9, "1:50-Group photo", "", R.color.blue_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 23, 14, 10, 15, 39, "11:30-Birds of a feather", "", R.color.oyellow, "Building D/Room 1+2", "\n" +
                    "\n" +
                    "On Friday, Saturday and Sunday of State of the Map, we will have several spaces for informal “Birds of a Feather” (BoFs). These are informal get meetings, planned ahead or thought up spontaneously. Discussions, mapping, code and documentation sprints, and hacking sessions, whatever you want! The sessions will take place in the Foyer and “Building D” classrooms, adjacent to the main conference hall. We will have a sign up board prominently in the main area to schedule sessions and add ideas.\n" +
                    "\n" +
                    "For now, start to share and discuss your ideas by posting them on http://wiki.openstreetmap.org/wiki/State_Of_The_Map_2016/Informal_Sessions#Birds_of_a_Feather_Sessions\n");
            createEvent(Calendar.SEPTEMBER, 23, 15, 40, 16, 9, "3:40-Coffee/Tea", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 23, 16, 10, 17, 39, "11:30-Birds of a feather", "", R.color.oyellow, "Building D/Room 1+2", "\n" +
                    "\n" +
                    "On Friday, Saturday and Sunday of State of the Map, we will have several spaces for informal “Birds of a Feather” (BoFs). These are informal get meetings, planned ahead or thought up spontaneously. Discussions, mapping, code and documentation sprints, and hacking sessions, whatever you want! The sessions will take place in the Foyer and “Building D” classrooms, adjacent to the main conference hall. We will have a sign up board prominently in the main area to schedule sessions and add ideas.\n" +
                    "\n" +
                    "For now, start to share and discuss your ideas by posting them on http://wiki.openstreetmap.org/wiki/State_Of_The_Map_2016/Informal_Sessions#Birds_of_a_Feather_Sessions\n");
        } else if (day.equals("Day 24")) {
            //Saturday
            createEvent(Calendar.SEPTEMBER, 24, 8, 0, 8, 59, "8:00-Coffee/Tea", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 24, 9, 30, 10, 59, "9:30-Birds of a feather", "", R.color.oblue, "Building D/Room 1+2", "\n" +
                    "\n" +
                    "On Friday, Saturday and Sunday of State of the Map, we will have several spaces for informal “Birds of a Feather” (BoFs). These are informal get meetings, planned ahead or thought up spontaneously. Discussions, mapping, code and documentation sprints, and hacking sessions, whatever you want! The sessions will take place in the Foyer and “Building D” classrooms, adjacent to the main conference hall. We will have a sign up board prominently in the main area to schedule sessions and add ideas.\n" +
                    "\n" +
                    "For now, start to share and discuss your ideas by posting them on http://wiki.openstreetmap.org/wiki/State_Of_The_Map_2016/Informal_Sessions#Birds_of_a_Feather_Sessions\n");
            createEvent(Calendar.SEPTEMBER, 24, 11, 0, 11, 29, "11:00-Coffee / Tea", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 24, 11, 30, 12, 59, "11:30-Birds of a feather", "", R.color.omagenta, "Building D/Room 1+2", "\n" +
                    "\n" +
                    "On Friday, Saturday and Sunday of State of the Map, we will have several spaces for informal “Birds of a Feather” (BoFs). These are informal get meetings, planned ahead or thought up spontaneously. Discussions, mapping, code and documentation sprints, and hacking sessions, whatever you want! The sessions will take place in the Foyer and “Building D” classrooms, adjacent to the main conference hall. We will have a sign up board prominently in the main area to schedule sessions and add ideas.\n" +
                    "\n" +
                    "For now, start to share and discuss your ideas by posting them on http://wiki.openstreetmap.org/wiki/State_Of_The_Map_2016/Informal_Sessions#Birds_of_a_Feather_Sessions\n");
            createEvent(Calendar.SEPTEMBER, 24, 13, 0, 13, 59, "1:00-Lunch", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 24, 14, 0, 14, 29, "2:00-Birds of a feather", "", R.color.oblue, "Building D/Room 1+2", "\n" +
                    "\n" +
                    "On Friday, Saturday and Sunday of State of the Map, we will have several spaces for informal “Birds of a Feather” (BoFs). These are informal get meetings, planned ahead or thought up spontaneously. Discussions, mapping, code and documentation sprints, and hacking sessions, whatever you want! The sessions will take place in the Foyer and “Building D” classrooms, adjacent to the main conference hall. We will have a sign up board prominently in the main area to schedule sessions and add ideas.\n" +
                    "\n" +
                    "For now, start to share and discuss your ideas by posting them on http://wiki.openstreetmap.org/wiki/State_Of_The_Map_2016/Informal_Sessions#Birds_of_a_Feather_Sessions\n");
            createEvent(Calendar.SEPTEMBER, 24, 14, 30, 15, 29, "2:30-Birds of a feather", "", R.color.oblue, "Building D/Room 1+2", "\n" +
                    "\n" +
                    "On Friday, Saturday and Sunday of State of the Map, we will have several spaces for informal “Birds of a Feather” (BoFs). These are informal get meetings, planned ahead or thought up spontaneously. Discussions, mapping, code and documentation sprints, and hacking sessions, whatever you want! The sessions will take place in the Foyer and “Building D” classrooms, adjacent to the main conference hall. We will have a sign up board prominently in the main area to schedule sessions and add ideas.\n" +
                    "\n" +
                    "For now, start to share and discuss your ideas by posting them on http://wiki.openstreetmap.org/wiki/State_Of_The_Map_2016/Informal_Sessions#Birds_of_a_Feather_Sessions\n");
            createEvent(Calendar.SEPTEMBER, 24, 15, 30, 15, 59, "3:30-Coffee / Tea", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 24, 16, 0, 17, 30, "4:00-Birds of a feather", "", R.color.blue_dark, "Building D/Room 1+2 ", "\n" +
                    "\n" +
                    "On Friday, Saturday and Sunday of State of the Map, we will have several spaces for informal “Birds of a Feather” (BoFs). These are informal get meetings, planned ahead or thought up spontaneously. Discussions, mapping, code and documentation sprints, and hacking sessions, whatever you want! The sessions will take place in the Foyer and “Building D” classrooms, adjacent to the main conference hall. We will have a sign up board prominently in the main area to schedule sessions and add ideas.\n" +
                    "\n" +
                    "For now, start to share and discuss your ideas by posting them on http://wiki.openstreetmap.org/wiki/State_Of_The_Map_2016/Informal_Sessions#Birds_of_a_Feather_Sessions\n");

        } else {
            //Sunday
            createEvent(Calendar.SEPTEMBER, 25, 9, 0, 9, 59, "9:00-Cofee / Tea", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 25, 10, 0, 10, 29, "10:00-Birds of a feather", "", R.color.blue_dark, "Foyer + Building D/Room 3", "\n" +
                    "\n" +
                    "On Friday, Saturday and Sunday of State of the Map, we will have several spaces for informal “Birds of a Feather” (BoFs). These are informal get meetings, planned ahead or thought up spontaneously. Discussions, mapping, code and documentation sprints, and hacking sessions, whatever you want! The sessions will take place in the Foyer and “Building D” classrooms, adjacent to the main conference hall. We will have a sign up board prominently in the main area to schedule sessions and add ideas.\n" +
                    "\n" +
                    "For now, start to share and discuss your ideas by posting them on http://wiki.openstreetmap.org/wiki/State_Of_The_Map_2016/Informal_Sessions#Birds_of_a_Feather_Sessions\n");
            createEvent(Calendar.SEPTEMBER, 25, 10, 30, 10, 59, "10:00-Rendering your own maps workshop ", "Paul Norman ", R.color.omagenta, "Building D/Room 2", "This workshop will take you through setting up your own map rendering server using OpenStreetMap data. Basic Linux and PostgreSQL knowledge is required, as well as a computer or virtual machine running Ubuntu 16.04.");
            createEvent(Calendar.SEPTEMBER, 25, 11, 15, 11, 44, "11:15-Break", "", R.color.blue_dark, "Universty", "");
            createEvent(Calendar.SEPTEMBER, 25, 11, 45, 12, 40, "11:45-Birds of a feather ", "", R.color.oyellow, "Foyer + Building D/Room 3", "\n" +
                    "\n" +
                    "On Friday, Saturday and Sunday of State of the Map, we will have several spaces for informal “Birds of a Feather” (BoFs). These are informal get meetings, planned ahead or thought up spontaneously. Discussions, mapping, code and documentation sprints, and hacking sessions, whatever you want! The sessions will take place in the Foyer and “Building D” classrooms, adjacent to the main conference hall. We will have a sign up board prominently in the main area to schedule sessions and add ideas.\n" +
                    "\n" +
                    "For now, start to share and discuss your ideas by posting them on http://wiki.openstreetmap.org/wiki/State_Of_The_Map_2016/Informal_Sessions#Birds_of_a_Feather_Sessions\n");
            createEvent(Calendar.SEPTEMBER, 25, 12, 40, 12, 59, "11:45-Area Workshop ", "Jochen Topf ", R.color.omagenta, "Building D/Room 2", "Considering that the OSM data model doesn’t know anything about polygons and multipolygons, it is amazing that there are more than 200 million (multi)polygons in OSM. Let’s have a look at those polygons and multipolygons, at closed ways and relations, at the different ways of tagging areas, and at the myriad ways of getting those things wrong. And then lets talk about how we are going to fix things. This workshop is not about a new area datatype, it is about making the best out of the existing datatypes. It is part of an ongoing effort to ease mappers’ lives and the life of OSM data users by simplifying tagging rules and fixing invalid data");
            createEvent(Calendar.SEPTEMBER, 25, 13, 0, 13, 59, "1:00-Lunch", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 25, 14, 00, 14, 29, "2:00-Local Chapters congress ", "Mikel Maron, OpenStreetMap Foundation ", R.color.oblue, "Foyer", "So much of OpenStreetMap happens in Local Chapters. There’s an incredible diversity of cultures and geography represented in our local groups, yet we have so much in common. There is much to learn about organizing and closely supporting mapping communities, outside of the usual skills of making maps and working with tech. Let’s gather leaders in Local Chapters to figure out what kinds of organizational efforts we can share together.");
            createEvent(Calendar.SEPTEMBER, 25, 14, 30, 15, 14, "Birds of a feather ", "", R.color.oyellow, "Building D/Room 2 + Room 3", "\n" +
                    "\n" +
                    "On Friday, Saturday and Sunday of State of the Map, we will have several spaces for informal “Birds of a Feather” (BoFs). These are informal get meetings, planned ahead or thought up spontaneously. Discussions, mapping, code and documentation sprints, and hacking sessions, whatever you want! The sessions will take place in the Foyer and “Building D” classrooms, adjacent to the main conference hall. We will have a sign up board prominently in the main area to schedule sessions and add ideas.\n" +
                    "\n" +
                    "For now, start to share and discuss your ideas by posting them on http://wiki.openstreetmap.org/wiki/State_Of_The_Map_2016/Informal_Sessions#Birds_of_a_Feather_Sessions\n");
            createEvent(Calendar.SEPTEMBER, 25, 15, 15, 15, 44, "Break", "", R.color.blue_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 25, 15, 45, 16, 19, "3:45-Birds of a feather ", "", R.color.omagenta, "Foyer + Building D/Room 3", "\n" +
                    "\n" +
                    "On Friday, Saturday and Sunday of State of the Map, we will have several spaces for informal “Birds of a Feather” (BoFs). These are informal get meetings, planned ahead or thought up spontaneously. Discussions, mapping, code and documentation sprints, and hacking sessions, whatever you want! The sessions will take place in the Foyer and “Building D” classrooms, adjacent to the main conference hall. We will have a sign up board prominently in the main area to schedule sessions and add ideas.\n" +
                    "\n" +
                    "For now, start to share and discuss your ideas by posting them on http://wiki.openstreetmap.org/wiki/State_Of_The_Map_2016/Informal_Sessions#Birds_of_a_Feather_Sessions\n");
            createEvent(Calendar.SEPTEMBER, 25, 16, 20, 16, 59, "4:30-weeklyOSM in my language for my community ", "Manfred A. Reiter, weeklyOSM  ", R.color.oblue, "Building D/Room 2", "\n" +
                    "\n" +
                    "WeeklyOSM collates all the current news and ongoings in OpenStreetMap. We’d love to be able to publish weeklyOSM in more languages and expand the number of authors across all languages. During this workshop you will receive training in our content management system: OSM Blog Collector (OSMBC).\n" +
                    "\n" +
                    "Learn how to collect and edit articles. We explain what EN ES, OSM Calender2Markdown and Picture Tool are, and how to use them. We provide all you need to get to grips with the Admin Area in OSMBC. Following this session you will be experienced in OSMBC and will be able to help spread WeeklyOSM to your local community.\n");
            createEvent(Calendar.SEPTEMBER, 25, 17, 0, 17, 30, "5:00-Closing session VUB Building Q.A", "", R.color.colorAccent, "Vrije Universiteit Brussel", "");
        }
    }

    private void createEventsLocal2(String date) {
        if (date.equals("Day 23")) {
            createGenericsEvent();
            createEvent(Calendar.SEPTEMBER, 23, 10, 0, 10, 29, "10:00-OpenSolarMap: Crowdsourcing and machine learning to classify roofs ", "Michel Blancard, Etalab  ", R.color.oyellow, "Auditorium C", "How did we classify the 48 million roofs in France by their orientation and shape with minimum effort and time? First, we designed a gamified crowdsourcing platform to manually classify about 10,000 roofs. Then we used standard machine learning techniques (logistic regression and deep learning) to train an automated classifier. Applications include potential estimation of vegetalization and solar energy. The approach to augmenting human contribution impact with image processing techniques could be applied to a wide range of problems.");
            createEvent(Calendar.SEPTEMBER, 23, 10, 30, 10, 59, "10:30-A love-letter to OSM: Greetings from Brussels ", "Pieter Brusselman, Trage Wegen vzw ", R.color.opurple, "Auditorium C", "\n" +
                    "\n" +
                    "Pathways, biking routes, field roads or shortcuts: these are everyday features whom we rarely contemplate on. Yet what we consider self-evident, often stays invisible. Trage Wegen (literally ‘association for slow roads’) is an organization that celebrates these hidden gems, suitable for pedestrians and bikers.\n" +
                    "\n" +
                    "Trage Wegen, who have been working on government projects since 2013, will unravel their methodology of working with OSM-data. Their focus lies in making the walking-experience in Brussels more pleasant and easy. As a supporter of open data as a way of unlocking information, they are both a user and contributor to OSM – living proof of the necessity of OSM in making exciting things happen.\n");
            createEvent(Calendar.SEPTEMBER, 23, 11, 0, 11, 29, "11:00-Coffee/Tea", "", R.color.orange_dark, "Auditorium C", "");
            createEvent(Calendar.SEPTEMBER, 23, 11, 30, 11, 59, "11:30-OSM goes indoors: Why SNCF Transilien mapped 388 train stations with OpenStreetMap ", "Cynthia Gutton, SNCF Transilien  ", R.color.obrow, "Auditorium C", "\n" +
                    "\n" +
                    "SNCF Transilien is a French public carrier that operates 3 million trips each day in the Paris region on 14 lines and in 388 stations. In order to create new services to passengers, the French community helped to map all the stations at great detail in OpenStreetMap, creating a large database of indoor geographical data.\n" +
                    "\n" +
                    "Why did the French railway company SNCF support this open project? How did OSM became the main database to create maps for travelers’ information? SNCF Transilien’s Innovation Manager will share its strategy of co-contribution with the community.\n");
            createEvent(Calendar.SEPTEMBER, 23, 12, 0, 12, 29, "12:00-OSM goes indoors: Usages, tools and prospects ", "Antoine Riche, Adrien Pavie, Carto'Cité ", R.color.obrow, "Auditorium C", "\n" +
                    "\n" +
                    "Over the last two years a lot of indoor mapping activity has been going on in France. All Paris train stations have been mapped to great details, along with shopping malls, museums and universities. A number of tools and techniques have been developed to assist mappers and visualize indoor maps. To name a few: iD-indoor, OpenLevelUp, a DIY 360° camera kit and indoor localisation script.\n" +
                    "\n" +
                    "Through this talk we will highlight some of the best accomplishments and describe innovative tools and techniques. We will share some implications and concerns, on the map, on the tools, on the community.\n");
            createEvent(Calendar.SEPTEMBER, 23, 12, 30, 12, 59, "12:30-Open imagery matters: Remote mapping with OpenAerialMap ", " Daniel da Silva, Development Seed ", R.color.oyellow, "Auditorium C", "\n" +
                    "\n" +
                    "Remote mapping in OpenStreetMap requires access to openly licensed imagery. Working with a community of satellite companies and drone operators OpenAerialMap has been providing open access aerial imagery since last summer. Users can search through a web-based map browser, connect to an API, and upload imagery to publish open imagery. Imagery can be immediately loaded into iD or JOSM for tracing in OpenStreetMap.\n" +
                    "\n" +
                    "This talk will walk through the core components of OpenAerialMap (OAM). We will also share the results of the growth of the community and tools over the last year and share further plans for how imagery within OAM can be integrated with OSM. The OAM community is planning for more growth over the next year and anyone can get involved.\n");
            createEvent(Calendar.SEPTEMBER, 23, 13, 0, 13, 49, "1:00-Lunch", "", R.color.orange_dark, "Auditorium C", "");
            createEvent(Calendar.SEPTEMBER, 23, 13, 50, 14, 9, "1:50-Group photo", "", R.color.blue_dark, "Auditorium C", "");
            createEvent(Calendar.SEPTEMBER, 23, 14, 10, 14, 39, "2:10-State of OSRM  ", "Johan Uhle, Mapbox  ", R.color.omagenta, "Auditorium C", "\n" +
                    "\n" +
                    "The Open Source Routing Machine (OSRM) is a popular routing engine, providing blazing fast global route-finding on OpenStreetMap. In the last 12 months, OSRM has taken big-steps towards a world-class navigation experience for car drivers. We made route duration estimates more realistic, by allowing developers to provide custom speed and turn duration data. We also dramatically shortened pre-processing times and improved turn-by-turn guidance.\n" +
                    "\n" +
                    "In this talk we will explain these new features, highlight trade-offs we faced, and discuss the nitty-gritty of doing navigation on OpenStreetMap.\n");
            createEvent(Calendar.SEPTEMBER, 23, 14, 40, 15, 9, "2:40-Converting a regular carto project to vector tiles: OSM-carto case study ", "Rory McCann, Geofabrik ", R.color.oblue, "Auditorium C", "This talk explains how we in Geofabrik ported the openstreetmap-carto style from regular image tiles to vectortiles backed raster tiles. OSM-carto is a very complicated, and detailed style, and rendering raster images from a vector tile source with mapnik is not as easy as just changing the source. This talk explains those differences and how to overcome them, so you can port your regular style to vector tiles.");
            createEvent(Calendar.SEPTEMBER, 23, 15, 10, 15, 39, "3:10-SQL all the things: Exposing OSM data services to PostgreSQL users ", "Jorge Sanz, CARTO", R.color.oblue, "Auditorium C", "\n" +
                    "\n" +
                    "Accessing Location Data Services through web APIs has been common practice over the last years. When an organization needs to get access to geocoding and routing functionalities they choose a provider, implement their API and integrate that procedure into their business logic, typically building middleware on top of their database. What if we get access to those APIs directly into the database? Imagine a SQL function that get access to a geocoding service backed by OpenStreetMap. Or a another that allows you to generate isochrones for different times and transport methods.\n" +
                    "\n" +
                    "Through the collaboration between CARTO and Mapzen we’ve built an Open Source Postgres extension to provide a SQL interface for Location Data Services. On this talk we will present the work done at CARTO over the last year to integrate these procedures at the core level of our platform, so users are no longer dependent of a Graphical User Interface to get the best of OSM.\n");
            createEvent(Calendar.SEPTEMBER, 23, 15, 40, 16, 9, "3:40-Coffee/Tea", "", R.color.orange_dark, "Auditorium C", "");
            createEvent(Calendar.SEPTEMBER, 23, 16, 10, 16, 39, "4:10-Gardening OSM data with Overpass API ", " Roland Olbricht ", R.color.omagenta, "Auditorium C", "The review of the data by the community is an often cited advantage of OSM. Nonetheless, it is still difficult to make sense of whole changesets or to trace changes back to the individual user. In this talk, it is shown how the existing tools can be used together and a new approach to trace back automatically the origin of each individual tag with Overpass API is demonstrated. We will finally use the tools to figure out whether there are a relevant number of edit wars in OSM.");
            createEvent(Calendar.SEPTEMBER, 23, 16, 40, 17, 10, "4:40-Tiles under heavy artillery: Serving one billion maps per month ", "Loic Ortola, Jawg ", R.color.omagenta, "Auditorium C", "\n" +
                    "\n" +
                    "Some people wonder whether OSM can be a great fit for their business. In this talk, we are not going to discuss the documentation, maintainability, updates, and robustness issues of OSM-based maps. Neither will we try convincing you that going for OSM is an easy task.\n" +
                    "\n" +
                    "In this talk, we decided to save our breath, take out our heaviest Gatling weaponry and start shooting instead. Can serving maps with OSM be an efficient, distributed, business-grade system? Bring your bulletproof vest and come find out.\n");
            createEvent(Calendar.SEPTEMBER, 23, 17, 10, 17, 40, "5:10-A stroll through the hidden corners of Taginfo", "Jochen Topf", R.color.omagenta, "Auditorium C", "Taginfo has been around for over 5 years now and it has proven to be a valuable tool for mappers and users of OSM data. Thousands of people consult it every day. But I bet there are a lot of features you didn’t know exist. This talk will highlight some of the less known corners of Taginfo, show you how it can make you more productive, and how you can waste countless hours finding the odds and ends in the OSM database.");
        } else if (date.equals("Day 24")) {
            //Saturday
            createEvent(Calendar.SEPTEMBER, 24, 8, 0, 8, 59, "8:00-Registration/Coffee/Tea", "", R.color.orange_dark, "Auditorium C", "");
            createEvent(Calendar.SEPTEMBER, 24, 9, 30, 9, 59, "9:30-The World We Want: OpenStreetMap and the Sustainable Development Goals ", "Tyler Radford, Humanitarian OpenStreetMap Team", R.color.oblue, "Auditorium C", "\n" +
                    "\n" +
                    "In early 2016, Humanitarian OpenStreetMap Team (HOT) made a commitment to the Global Partnership for Sustainable Development Data. As part of this process, HOT mapped the work of the global OSM community to the 17 UN Sustainable Development Goals. Incredibly, (or perhaps not so surprisingly), it was found that the global OSM community is contributing to nearly all of the goals.\n" +
                    "\n" +
                    "This talk aims to raise awareness of the many ways that OSM data, and also the process by which it is generated, are contributing to a more equitable world. From measuring financial inclusion in Uganda (Goal 1: No Poverty), to providing vocational training and jobs (Goal 4: Quality Education), to mapping housing conditions and access to basic services in informal settlements (Goal 11: Sustainable Cities and Communities), OSM is front and centre in each of these projects.\n");
            createEvent(Calendar.SEPTEMBER, 24, 10, 0, 10, 29, "10:00-Building large-scale crowdsourcing communities with the Humanitarian OpenStreetMap Team ", "Martin Dittus, ICRI Cities, UCL ", R.color.oblue, "Auditorium C", "\n" +
                    "\n" +
                    "Since its inception in 2010, the Humanitarian OpenStreetMap Team (HOT) has coordinated thousands of volunteers in the creation of maps for humanitarian purposes. Contributors have traced satellite images and digitised field data in response to Typhoon Haiyan, the 2015 Nepal earthquake, the Ebola epidemic, and many other disasters. Despite these efforts, large parts of the world remain unmapped. With ambitions to fix this HOT are now trying to understand how to grow the largest crowdsourcing community on the planet.\n" +
                    "\n" +
                    "Martin presents his research on this growth challenge. In attempting to understand how to recruit and retain an active contributor community, Martin’s research has covered the initial contributor experience, understanding the practices and concerns of the community and reviewing how expertise is shared. The research involves large-scale quantitative studies based on the contribution history of thousands of participants.\n");
            createEvent(Calendar.SEPTEMBER, 24, 10, 30, 10, 59, "10:30-State of West Africa ", "Mohamet Lamine N'Diaye, Dibloni Innocent Soungalo, OpenStreetMap Senegal & Association OpenStreetMap Burkina Faso ", R.color.opurple, "Auditorium C", "\n" +
                    "\n" +
                    "Mohamet Lamine N’Diaye will present OpenStreetMap Senegal’s history and voluntary activities since 2012 (advocacy, training, field mapping, mapathons). He will also discuss their interactions with other OSM communities in West Africa and worldwide.\n" +
                    "\n" +
                    "As a founding member of the OpenStreetMap association of Burkina Faso, Dibloni Innocent Soungalo will describe the activities, achievements and goals of the association. This includes promotion of OSM via mapathons, surveys, training and workshops. But also working with other open data communities, private or government organisations, to help them discover OSM and the many use cases it could have for them.\n" +
                    "\n");
            createEvent(Calendar.SEPTEMBER, 24, 11, 0, 11, 29, "11:00-Coffee / Tea", "", R.color.orange_dark, "Auditorium C", "");
            createEvent(Calendar.SEPTEMBER, 24, 11, 30, 11, 59, "11:30-MapContrib: Thematic OpenStreetMap contribution ", "Guillaume Amat ", R.color.omagenta, "Auditorium C", "MapContrib is a new OpenStreetMap contribution tool, built for thematic editing. It wants to be simple, for web and mobile. It was well received with great feedback at the French SOTM this year, what about the rest of map?");
            createEvent(Calendar.SEPTEMBER, 24, 12, 0, 12, 29, "12:00-The minimalist OSM Building Editor ", "Jan Marsch, OSM Buildings ", R.color.omagenta, "Auditorium C", "\n" +
                    "\n" +
                    "Today OpenStreetMap has mapped 188 million buildings. This is an awesome number! But for the majority little more than a geometry footprint is available. For spatial orientation, navigation, solar potential analysis, risk detection and others there is a demand for more specific tagging. Using a new focused editor you can help collect this data without worrying about other OSM data.\n" +
                    "\n" +
                    "Brick (working title) offers a minimalistic set of editable attributes: height, colour, building purpose, roof type. It runs as a mobile web application and thanks to OSM API and an OSM Buildings viewer, results are visible immediately. In this talk, Jan will guide you through the editor and discuss the technical aspects. Use Brick it during the session provide feedback.\n");
            createEvent(Calendar.SEPTEMBER, 24, 12, 30, 12, 59, "12:30-Portable OSM: Into the disconnected wilds ", "Emily Eros, American Red Cross ", R.color.omagenta, "Auditorium C", "\n" +
                    "\n" +
                    "OpenStreetMap’s offline tools are amazing. But for intensive mapping by small teams, coordinating contributions can be difficult; especially when you lack reliable internet connectivity! Because the Red Cross’ mapping locations are so remote, a better way to interact and edit OSM in a disconnected way for days and potentially weeks at a time was required.\n" +
                    "\n" +
                    "Portable OSM combines an offline OSM API, Field Papers, OpenMapKit, a captive portal, and many new enhancements to the OSM workflow. Using very cheap hardware (<$300), contributors are able to download an area of interest, work offline in the field (editing with familiar tools), and then return to a connected environment and sync all changes back to OpenStreetMap.\n" +
                    "\n" +
                    "This session will take you through the design and architecture process, experiences of using Portable OSM in real world conditions and show you how to set up your own instance.\n" +
                    "\n");
            createEvent(Calendar.SEPTEMBER, 24, 13, 0, 13, 59, "1:00-Lunch", "", R.color.orange_dark, "Auditorium C", "");
            createEvent(Calendar.SEPTEMBER, 24, 14, 0, 14, 29, "2:00-TeachOSM: Harnessing the power of OpenStreetMap for geography education", " Maggie Cawley, Boomerang Geospatial ", R.color.oblue, "Auditorium C", "\n" +
                    "\n" +
                    "TeachOSM is dedicated to making OpenStreetMap the on-ramp to a rich world of open source mapping tools and educational activities. Because of their low cost and relative accessibility, OpenStreetMap and the related ecology of open source geospatial tools are ideal for teaching the fundamental concepts of geography and mapping.\n" +
                    "\n" +
                    "This talk will feature case studies of TeachOSM workshops in the Caribbean and Mauritius that focused on the use of OpenStreetMap, open data, and QGIS. These projects show how teaching open mapping techniques contribute to strengthening economies and providing accurate maps of the local communities. OSM has led to the delivery a new generation geospatial tools that have the potential to improve geography education. Join Maggie and help make a plan to bring OpenStreetMap into classrooms all over the world.\n" +
                    "\n");
            createEvent(Calendar.SEPTEMBER, 24, 14, 30, 14, 59, "2:30-Map it forward: Incorporating OSM into the universities curriculum ", " Vasanthi Hargyono, Humanitarian OpenStreetMap Team (Indonesia) ", R.color.oblue, "Auditorium C", "\n" +
                    "\n" +
                    "What started as a spontaneous day of OSM training for a very eager lecturer & his 15 students has now grown in to fully developed training method. Last year this method was used in 13 universities to certify more than 50 students as champions/trainers in their provinces. 5 universities have incorporated OSM into their curriculum.\n" +
                    "\n" +
                    "Vasanthi will discuss that initial project in Makassar, the biggest city in East Indonesia. Learn how it led to a massive explosion in map contributors (900k buildings are now mapped), and how it developed into an educational program. Having access to free map data has already paid dividends – the city government used the data to create an accurate flood contingency planning.\n");
            createEvent(Calendar.SEPTEMBER, 24, 15, 0, 15, 29, "3:00-OpenStreetMap for educational purposes ", "Louis-Julien de la Bouëre, Tiriad  ", R.color.oblue, "Auditorium C", "I work a lot on how we can use OpenStreetMap with children in many ways for many objectives (knowing our daily environment, talking about commons, sharing our knowledge…). We also have experience of work with youth workers in social center, etc. We would like to share our initiatives, our experiences to spread OSM in direction of youngs in the world.");
            createEvent(Calendar.SEPTEMBER, 24, 15, 30, 15, 59, "3:30-Coffee / Tea", "", R.color.orange_dark, "Auditorium C", "");
            createEvent(Calendar.SEPTEMBER, 24, 16, 0, 16, 29, "4:00-What, where... when! Let's add another dimension with OpenEventDatabase ", "Christian Quest, OpenStreetMap France ", R.color.oyellow, "Auditorium C", "\n" +
                    "\n" +
                    "OSM data represent a “static” world and is not designed to share time related data. As an example, we can do route calculations but they cannot take into account traffic jams, closed roads or road work.\n" +
                    "\n" +
                    "OpenEventDatabase’s goal is to provide an open platform to share “events” which are data with “what”, “where” and “when” details. An open API is available since May 2016 and the project is available on GitHub. The content is currently fed with weather warnings and alerts and motorway traffic information, with more planned.\n" +
                    "\n");
            createEvent(Calendar.SEPTEMBER, 24, 16, 30, 16, 59, "4:30-OSM for traffic simulation ", "Michael Zilske, Technische Universität Berlin", R.color.oyellow, "Auditorium C", "Microsimulations of traffic systems require detailed input data about the road network, public transit, and land use (to estimate travel demand). At SOTM-EU Vienna, I introduced our simulation model (MATSim) and remarked that OSM had already become our preferred source for road network data. Since then, we have created several simulation scenarios from OSM, and we created a JOSM plug-in to export network data to MATSim (encouraging researchers to contribute corrections back to OSM instead of making them locally in the target format). I would like to report on the joint experience of the MATSim community using OSM data from diverse cities (including public transit tagging), and introduce traffic simulation to the OSM community at large.");
            createEvent(Calendar.SEPTEMBER, 24, 17, 0, 17, 30, "5:00-Railways at OpenStreetMap ", "Michael Reichert, OpenRailwayMap", R.color.oyellow, "Auditorium C", "\n" +
                    "\n" +
                    "Railway infrastructure is a topic most people either do not know much about or do not want to know much about. It is a rather exotic topic but it has its fans. Well-known by lots of railway fans, OpenRailwayMap is a map of the railway infrastructure (tracks, signals, speed limits, electrification) but unlike other special-interest maps, it is quite country-dependent because railway signalling differs between countries very much.\n" +
                    "\n" +
                    "Michael will present mapping and tagging of railway-specific data, how good railway-specific data currently is and highlight work work is needed to port OpenRailwayMap to more countries.\n" +
                    "\n");
        } else {
            //Sunday
            createEvent(Calendar.SEPTEMBER, 25, 9, 0, 9, 59, "9:00-Cofee / Tea", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 25, 10, 0, 10, 29, "10:00-OpenStreetView for mappers", "Alex Ilisei, Martijn van Exel, Telenav ", R.color.oyellow, "Room QC", "OpenStreetView is the free and open street level imagery platform designed 100% with OSM mappers in mind. In this workshop, we will walk you through all the components of OSV: the open source mobile apps, the OSV editor, JOSM plugins, and web site. We hope to also be able to show you an early version of iD integration. Once we get that out of the way, we will look at some tips and tricks specific to mapping with OSV, and there will be lots of time to answer all your questions around the OSV platform. Bring your laptop and smartphones!");
            createEvent(Calendar.SEPTEMBER, 25, 10, 30, 10, 59, "10:00-Learn to map: Making mapping fun ", "Miriam Gonzalez, OpenStreetMap Mexico & Telenav", R.color.oblue, "Building D/Room 1", "\n" +
                    "\n" +
                    "Over the past two years I have been organizing and giving OpenStreetmap workshops for Universities, Government authorities and Civil Society. I’ve learned how to make them fun and keep people engaged during and after the workshop.\n" +
                    "\n" +
                    "If you are new to OpenStreetMap, or just want a refresher course, then join me in the workshop. I include the following: - Introduction to OSM (what is OpenData, benefits of OSM, how to use it for Humanitarian purposes) - Introduction to ID Editor (description and then exercise together) - HOTOSM Tasking Manager - Contest to finish in 15 days to the person who maps the most\n" +
                    "\n" +
                    "I can also provide some “train the trainers” tips based on what I have seen work the best for the attendee. If you’re a trainer join me in this session to help the new mappers and pick up some ideas.\n" +
                    "\n");
            createEvent(Calendar.SEPTEMBER, 25, 11, 15, 11, 44, "11:15-Break", "", R.color.blue_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 25, 11, 45, 12, 40, "11:45-Learn to create your own challenges in MapRoulette using Overpass ", "Martijn van Exel, MapRoulette ", R.color.oyellow, "Room QC", "\n" +
                    "\n" +
                    "A new Maproulette has replaced the old, and creating challenges is now easier than ever. In this workshop, we will take you behind the scenes and introduce you the art of crafting MapRoulette challenges. You will learn how to use Overpass queries to create challenges in seconds, and we will lift the veil on using the MapRoulette API and administration interface that is available to challenge administrators. You will come out of this session ready to create your own challenges to share with your local community or mappers all over the world!\n" +
                    "\n");
            createEvent(Calendar.SEPTEMBER, 25, 12, 40, 12, 59, "11:45-Improving the canvas for participatory mapping in Tanzania ", "Egle Marija Ramanauskaite, Janet Chapman, Crowd2Map ", R.color.blue_dark, "Building D/Room 1", "\n" +
                    "\n" +
                    "At Crowd2Map Tanzania we are working on engaging as much local participation in mapping. Much of the map remains blank and getting local knowledge is essential, especially so in rural Tanzania. We have explored different apps to facilitate mapping. The challenge being low literacy and limited technological capabilities of participants. We have settled on using Maps.me app, however the blank base map makes it very difficult for locals to map their communities accurately.\n" +
                    "\n" +
                    "During the workshop we will engage in hands-on mapping to bring Maps.me points (which have been collected so far) to OSM standards. We will also work on the ways to make ground mapping more effective, e.g. by creating better base maps. By tapping the rich experience of the OSM community, we envision the main outcome of the workshop to be a solid long-term plan to facilitate effective ground mapping in the local communities that could be scalable to any developing country.\n");
            createEvent(Calendar.SEPTEMBER, 25, 13, 0, 13, 59, "1:00-Lunch", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 25, 14, 00, 14, 29, "2:00-The state of public transport routing ", " Pieter Colpaert, Open Knowledge International ", R.color.omagenta, "Room QC", "\n" +
                    "\n" +
                    "Many public transit route planning interfaces exist for public transit route planning as open source, as a software as a service, or as end-user applications. GTFS has become the de facto standard for exchanging public transit timetables, yet the glue between these GTFS files (for example providing transfer times and footpaths) is a map layer such as OpenStreetMap.\n" +
                    "\n" +
                    "The workshop, organised by members of the Open Transport working group at Open Knowledge International, will discuss the state of the art and the next steps within public transit route planning.\n");
            createEvent(Calendar.SEPTEMBER, 25, 14, 30, 15, 14, "2:00-Mastering uMap ", "Yohan Boniface", R.color.oyellow, "Building D/Room 1 ", "uMap lets you create a map with OpenStreetMap layers and embed it in your site, all within a few minutes. In this workshop let’s take some time to discover the more advanced or hidden features: remote layers, overpass integration and custom templates. You’ll be amazed at how simple it is to create great maps");
            createEvent(Calendar.SEPTEMBER, 25, 15, 15, 15, 44, "Break", "", R.color.blue_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 25, 15, 45, 16, 19, "3:45-Create your own tile server with TileStache ", "Thomas Gratier, Ouvre-Boite 44 - WebGeoDataVore", R.color.omagenta, "Room QC", "Although vector tile servers are all the rage, creating a simple tile server for raster is already the first step to host your own custom tiles. We will review using TileStache how to do it. We will provide your the step to install the server, load a simple OSM project and then play with styles. We will see also show how to consume vector tiles as sources for server raster tiles.");
            createEvent(Calendar.SEPTEMBER, 25, 16, 20, 16, 59, "3:45-Osmose-QA: Fix issues and understand the tool ", "Frédéric Rodrigo ", R.color.ogreen, "Building D/Room 1", "\n" +
                    "\n" +
                    "Osmose is one of many quality assurance tools available to detect issues in OpenStreetMap data. In this workshop you will learn how to use it. We start by simply looking around on the map to locate possible issues on data. Get to grips with the list of issue categories and learn how to fix problems.\n" +
                    "\n" +
                    "For the advanced people in the room we will go further to look at statistics, filters and the API. Let’s also discuss how to improve the data analysers so we can intelligently spot new data problems.\n");
            createEvent(Calendar.SEPTEMBER, 25, 17, 0, 17, 30, "5:00-Closing session VUB Building Q.A", "", R.color.colorAccent, "Vrije Universiteit Brussel", "");
        }
    }

    private void createEventsLocal1(String date) {
        if (date.equals("Day 23")) {
            createGenericsEvent();
            createEvent(Calendar.SEPTEMBER, 23, 10, 0, 10, 29, "10:00-OpenStreetMap Analytics ", "Cristiano Giovando, Humanitarian OpenStreetMap Team ", R.color.ogreen, "Auditorium A", "\n" +
                    "\n" +
                    "With a global community of over 2.5 million registered users and a planet reaching the 50GB file size, making sense of OSM data, globally, locally, and temporally, presents significant challenges. In 2016 an online platform which could filter by user, timeslider, custom drawn areas and more was born.\n" +
                    "\n" +
                    "Built by the Humanitarian OpenStreetMap Team, with support by key partners, the application relies on daily preprocessing routines of OSM QA Tiles and data aggregation into vector tiles. By making OSM data facts easily accessible through an intuitive user interface, OSM-Analytics.org wants to become the go-to place for tracking progress on community mapping projects, assessing map coverage, and telling data-rich map stories. Cristiano explains all.\n");
            createEvent(Calendar.SEPTEMBER, 23, 10, 30, 10, 59, "10:30-Nicaragua's new crowd-sourced bus map: Lessons learnt ", "Eduardo Augusto Mayorga, Felix Delattre, MapaNica", R.color.oyellow, "Auditorium A", "\n" +
                    "\n" +
                    "In Managua, Nicaragua, over 1.5 million inhabitants are dependent on public transport but until now there had been no map of the 45 bus lines. Using free technology, crowd-funding and the power of collaboration, engaged citizens worked together to create the first complete public transportation map of any Central American capital.\n" +
                    "\n" +
                    "Felix and Eduardo Augusto will discuss how they achieved this, produced a web app, gave away 40,000 free printed maps and generated a GTFS feed for routing. Not only will they present the final products, but by sharing the lessons learnt during surveying and creating open data in a developing country, they hope to inspire you too.\n");
            createEvent(Calendar.SEPTEMBER, 23, 11, 0, 11, 29, "11:00-Coffee/Tea", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 23, 11, 30, 11, 59, "11:30-Energise your community with focused projects", "Brian Prangle, Mappa Mercia ", R.color.oblue, "Auditorium A", "Building a community from scratch? Trying to expand an early OpenStreetMap community? Brian will share his experiences from recent projects in the UK. These include national mapping projects and collaborations with UK local authorities. A number of projects will be described (from mapping schools to automatic traffic flow management) and some hints provided on what works well and what doesn’t");
            createEvent(Calendar.SEPTEMBER, 23, 12, 0, 12, 29, "12:00-Investing in OSM communities to build resilience ", "Vivien Deparday, World Bank - Global Facility for Disaster Reduction and Recovery ", R.color.oblue, "Auditorium A ", "\n" +
                    "\n" +
                    "The World Bank launched the Open Data for Resilience Initiative (OpenDRI) and has been engaging in community mapping projects since its inception in 2011. The aim is to bring stakeholders together to create data and tools to inform decision-making related to urban planning and disaster risk management. But it’s equally important to develop a level of trust necessary for these efforts to become sustainable.\n" +
                    "\n" +
                    "Illustrated with many examples, this talk will address the following questions by presenting core principles of engagement and best practices to design successful community mapping activities.\n" +
                    "\n" +
                    "    How can we use community mapping to increase resilience to natural hazards and the impacts of climate change?\n" +
                    "    What makes a community mapping project successful?\n" +
                    "    What are the strategies for engaging local stakeholders and creating cross-organization communities?\n" +
                    "    How can we measure sustainability of a local OpenStreetMap community?\n" +
                    "\n");
            createEvent(Calendar.SEPTEMBER, 23, 12, 30, 12, 59, "12:30-Vector tiles from OpenStreetMap", "Lukas Martinelli ", R.color.oblue, "Auditorium A", "\n" +
                    "\n" +
                    "The OSM2VectorTiles project offers free downloadable vector tiles from OpenStreetMap data ready to use by people interested in hosting custom base maps on their own infrastructure. The whole world fits on a USB stick and can be served from an ordinary web hosting and styled and enriched to make beautiful and fast maps for web and mobile applications.\n" +
                    "\n" +
                    "After this talk you will know how to create and publish your own custom styled maps based on completely Open Source vector tiles. You will also learn how to host vector tiles yourself or use them completely offline. We are map enthusiasts who want to make OpenStreetMap accessible for everyone again.\n");

            createEvent(Calendar.SEPTEMBER, 23, 13, 0, 13, 49, "1:00-Lunch", "", R.color.omagenta, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 23, 13, 50, 14, 9, "1:50-Group photo", "", R.color.blue_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 23, 14, 10, 14, 39, "2:10-A map of OpenStreetMap", "Mikel Maron, OpenStreetMap Foundation ", R.color.oblue, "Auditorium A", "\n" +
                    "\n" +
                    "There is no comprehensive picture of what the heck OpenStreetMap has become. What started as a crazy hacker project is now a vital part of the global data ecosystem yet also still a crazy complex hacker project. The number of mappers and organizations, new uses and ways to contribute, is growing ever faster. It’s hard to find your way as a newcomer, and even long timers can’t track how our community grows and transforms.\n" +
                    "\n" +
                    "We need a map. This talk will take some steps at charting out the landscape, investigate how diverse elements of OpenStreetMap interact, and some possible well designed and focused adaptations to our community structure and networks, like greater role for OSMF Members and Local Chapters, and ways to share burden of core software development. Let’s get started with a map and a plan to help connect our community closer together.\n");
            createEvent(Calendar.SEPTEMBER, 23, 14, 40, 15, 9, "2:40-WeeklyOSM: Why, how, what, where and where we go", "Manfred Reiter, Laura Barroso, weeklyOSM", R.color.oblue, "Auditorium A", "\n" +
                    "\n" +
                    "With forums, blogs, social media and more than 150 international mailing lists (and 50 regional lists in Germany alone) it is not possible for an interested mapper to be informed on the ongoings of the global community. In order to fill this gap Wochennotiz/weeklyOSM was created. It attempts to offer a way for publish all the projects and application developed for people who are passionate about OSM.\n" +
                    "\n" +
                    "In this talk we’ll share our experiences in the process of making the weeklyOSM every week for multiple languages (German, Spanish, English, Japanese, Czech), how we do it, how we proceed to collect every news and how we choose which get published. We will also discuss the impact on the OSM global communities.\n" +
                    "\n");
            createEvent(Calendar.SEPTEMBER, 23, 15, 10, 15, 39, "3:10-Is she a part of your community? ", "Srravya C, Free Software Foundation Tamil Nadu", R.color.oblue, "Auditorium A", "\n" +
                    "\n" +
                    "OSM is a global community and yet not diverse in the gender aspect. Though considerable effort has gone into introducing more women to the community, the transformation of newcomers into long standing contributors to the community doesn’t happen automatically. There seems to be need for dedicated efforts to help novice women gain their foothold in the domain.\n" +
                    "\n" +
                    "Based on her efforts and experiments to improve the diversity of the community, Srravya will propose three specific guidelines as a first step for communities to provide a congenial environment for women to be active participants. The talk will also touch upon the importance of participation from all genders and not just women. The aim is not just to promote and increase participation of women but to evolve as a truly open and diverse community with participants from all and any gender.\n");
            createEvent(Calendar.SEPTEMBER, 23, 15, 40, 16, 9, "3:40-Coffee/Tea", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 23, 16, 10, 17, 10, "4:10-Lightning Talks", "Multiple speakers", R.color.oyellow, "Auditorium A ", "");
            createEvent(Calendar.SEPTEMBER, 23, 17, 10, 17, 40, "5:10-State of the licence", "Simon Poole, OSMF", R.color.oblue, "Auditorium A", "\n" +
                    "\n" +
                    "In September 2016 it will 4 years will have passed since OpenStreetMap changed its licence from CC by-SA 2.0 to the ODbL 1.0. Time to make a tally of the aftermath.\n" +
                    "\n" +
                    "The session will cover * a final damage estimate * the guideline process, guidelines in force and what is in the works * the day-to-day work of the Licence Working Group * a look at the future\n");
        } else if (date.equals("Day 24")) {
            //Saturday
            createEvent(Calendar.SEPTEMBER, 24, 8, 0, 8, 59, "8:00-Registration/Coffee/Tea", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 24, 9, 30, 9, 59, "9:30-Trending Places on OpenStreetMap", "Stefan Keller, Geometa Lab at HSR, Univ. of Applied Sciences Rapperswil", R.color.ogreen, "Auditorium A", "\n" +
                    "\n" +
                    "Current news or a popular event in a region may result in a increase in map views. The goal of “Trending Places on OpenStreetMap” is to locate where there is a high viewing activity occurs on the main OpenStreetMap web map. The map consists of many tiles and the views of these tiles are logged daily and following processing the top trending places are tweeted by @trending_places.\n" +
                    "\n" +
                    "Stefan describes the process: For previous 7 days the tile view log is aggregated up to zoom level 14 and a so called T-score is calculated to standardize the data. Values above a certain threshold are filtered out to catch spikes and these are then ranked relative to the mean increase in views overall. Clustering eliminates locations that are near one another. Finally, the tile coordinates are reverse geocoded in order to get geographic names and a Twitter bot announces the top 10.\n");
            createEvent(Calendar.SEPTEMBER, 24, 10, 0, 10, 29, "10:00-Using big data to help us improve the map", " Beata Jancso, Telenav", R.color.ogreen, "Auditorium A", "\n" +
                    "\n" +
                    "Drivers using Telenav’s OpenStreetMap based Scout applications generate a continuous stream of location information. Liquid gold as it turns out! Using sophisticated matching and generalization techniques, Telenav’s OSM engineers create something beautiful out of those billions of raw data points. We call it Improve OSM. A suite of tools that highlight small mapping tasks for contributing to OSM in a meaningful way.\n" +
                    "\n" +
                    "In this technical talk lead OSM engineer, Beata Jancso, will dig beneath the surface to reveal some of the elaborate data processing and the technology stack we built to make all this possible. If you are interested in how to apply big data concepts to OpenStreetMap to gain high-value intelligence for improving the map, this is a talk you do not want to miss. With exciting improvements planned, we hope to leave some time to talk about the future of Improve OSM.\n");
            createEvent(Calendar.SEPTEMBER, 24, 10, 30, 10, 59, "10:30-Tracking OpenStreetMap changes: Merging changeset and metadata together for improved change tracking", "Dylan Moriarty, Development Seed", R.color.ogreen, "Auditorium A", "\n" +
                    "\n" +
                    "Working together with the American Red Cross and the MissingMaps project, we’ve built a system that tracks user contributions to Missing Maps projects around the globe. Minute by minute it calculates statistics, provides leader boards and awards themed badges for contributions. It’s making editing a more social experience.\n" +
                    "\n" +
                    "Tracking changes in OpenStreetMap is difficult but incredibly useful for the community. Tracking changes in real-time requires a pipeline to merge metadata, changeset data, and diff information. This talk will explore the motivation, architecture, and practical implementation of a system. One that reliably handles bursts of data during high periods of activity, yet reduces costs by auto scaling to input as required. We’ll talk about how these methods have been implemented using services such as AWS Kinesis and Lambda functions.\n");
            createEvent(Calendar.SEPTEMBER, 24, 11, 0, 11, 29, "11:00-Coffee / Tea", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 24, 11, 30, 11, 59, "11:30-Camp-mapping in Greece", "Henk Hoff, Red Cross (international)", R.color.oblue, "Auditorium A", "\n" +
                    "\n" +
                    "The Red Cross is mapping migrant camps in Greece. The project entails some basic infrastructure mapping of the various camps (based on recent aerial imagery), from which we we will work together with migrants in the camps to further enrich the map with detailed, relevant information. These maps will be used for interaction of parties active in the camps to engage with the people living there. And of course, can also be used by migrants amongst each other.\n" +
                    "\n" +
                    "The presentation will cover why we started this project, how we have set it up and how we are using the map in our work. Realizing the approach being similar to what Mapfugees have done in Calais, both organizations are now in contact with each other to further work on the implementation of the mapping-by-migrants phase.\n");
            createEvent(Calendar.SEPTEMBER, 24, 12, 0, 12, 29, "12:00-OpenSchoolsKenya ", "Zacharia Muindi, Map Kibera Trust ", R.color.oyellow, "Auditorium A", "\n" +
                    "\n" +
                    "Open Schools Kenya is making information about education facilities easily available and useful to everyone. The project, which focuses on Kibera as a pilot site, is supported by Gates Foundation and implemented by Map Kibera. So far 350 schools have been mapped including informal, private and public schools. This has enabled parents to make informed choices, whilst the government, NGOs and donors can use the data to target funding and improve planning.\n" +
                    "\n" +
                    "Zacharia will discuss how the data was collected, and uploaded into OSM. From this a website was created to give each and every school a profile page with details ranging from the population, programs offered, fees, and contact info.\n");
            createEvent(Calendar.SEPTEMBER, 24, 12, 30, 12, 59, "12:30-Mapping Ireland's 61,000 administrative boundaries ", " Rory McCann, OpenStreetMap Ireland ", R.color.opurple, "Auditorium A", "\n" +
                    "\n" +
                    "For the last 6 years, the Irish OSM community has been manually tracing Ireland’s smallest administrative boundaries, townlands, from scanned maps from the 1830s and 1840s. We’ll explain how we’re doing it, what tech we needed, and how you get people to stare at really old maps for hours on end.\n" +
                    "\n" +
                    "We will explore the reasons why this project seemed to catch the imagination of mappers in Ireland and elsewhere. Some of the reasons may be specific to this project - the nature of what was being mapped is in the DNA of many Irish residents! But much is of value more widely, indicating structures and support which maximise engagement and produce accurate and effectively mapping.\n");
            createEvent(Calendar.SEPTEMBER, 24, 13, 0, 13, 59, "1:00-Lunch", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 24, 14, 0, 14, 29, "2:00-Watching for vandalism", "Sajjad Anwar, Mapbox", R.color.ogreen, "Auditorium A", "\n" +
                    "\n" +
                    "OpenStreetMap today is much more than a street map. The data is used for navigation, data visualisation, art, urban planning and much more. Today, there were over 20k changesets - making OSM one of the most active open data projects with great adoption. Accidental edits and attempts at vandalism make a bigger impact than they used to. Mapbox are learning about these problems and approaching them holistically - fixing issues every day, using existing tools, improving editing software, and building new tools and workflows for emerging problems.\n" +
                    "\n" +
                    "Sajjad will share what they have learned so far. He will discuss technical details and challenges behind the tools and workflows they are building, how they gather feedback, ideas and insights from the community, and talk about first response systems to maintain OSM as the best map of the world.\n" +
                    "\n");

            createEvent(Calendar.SEPTEMBER, 24, 14, 30, 14, 59, "2:30-Trace from Space: International version", "Kevin Bullock, DigitalGlobe", R.color.ogreen, "Auditorium A", "\n" +
                    "\n" +
                    "Anyone who has edited OpenStreetMap (OSM) has used DigitalGlobe imagery; they might not realize it, they might refer to it as “Bing” or “Nextview”, but all OSM users are DigitalGlobe users.\n" +
                    "\n" +
                    "DigitalGlobe is the team who are building, launching, operating and provisioning high resolution, accurate images that power OSM. Just days ago we launched of our newest satellite: WorldView-04, which will ensure data continuity for the next decade. This talk will cover how DigitalGlobe will continue to innovate and provide data to OSM that will allow OSM to go to the next level in terms of relevant coverage and detail. It will also cover DigitalGlobe’s Open Data initiative and ecosystem of partners in the Geo industry.\n");
            createEvent(Calendar.SEPTEMBER, 24, 15, 0, 15, 29, "3:00-OpenStreetMap US: The real McCoy", "Drishtie Patel, Alyssa Wright, Ian Dees, Alex Barth, Martijn van Exel, OpenStreetMap US ", R.color.oblue, "Auditorium A", "\n" +
                    "\n" +
                    "OpenStreetMap US is one of the most significant OpenStreetMap communities in the world. Organized in 2009, OpenStreetMap US manages the largest budget, conference, website, and mapathons. We have also supported the production of key OpenStreetMap development tools such as MapRoulette and iD Editor, collaborated with federal, state and local government agencies, and assisted with ten major OpenStreetMap humanitarian response. And – we are friendly! From its very beginnings, OpenStreetMap US has been a functional model of communication and action.\n" +
                    "\n" +
                    "In this presentation the entire US board would like to reflect on lessons learned as a contribution to the international OpenStreetMap community. With some of us involved in OpenStreetMap leadership for over ten years, we will summarize what we have learned from local investment and the vision we are moving towards for national impact.\n");
            createEvent(Calendar.SEPTEMBER, 24, 15, 30, 15, 59, "3:30-Coffee / Tea", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 24, 16, 0, 16, 29, "4:00-Empowering women through OpenStreetMap in Mali ", " Astou Nathalie Sidibe, OpenStreetMap Mali ", R.color.opurple, "Auditorium A", "\n" +
                    "\n" +
                    "As a young leader in Mali, Nathalie understands the importance of open data in resolving some of the challenges the country faces. Inspired by Espace OSM Francophone (EOF) workshops, and with the support of other young leaders, she created the Malian OpenStreetMap Community.\n" +
                    "\n" +
                    "In this session Nathalie will describe the goals, challenges, achievements and expectations of the community. She’ll share her experiences mobilising the community via mapping parties and workshops. As a woman in a male-dominated environment, this hasn’t always been easy. Despite negative thoughts against women in Africa, Nathalie doesn’t give up and now strives to support social strategies that empower women through OpenStreetMap.\n");
            createEvent(Calendar.SEPTEMBER, 24, 16, 30, 16, 59, "4:30-Building a digital humanitarian society in Pakistan: A perspective", "Usman Latif, DigitalHumanitarians.pk ", R.color.opurple, "Auditorium A", "\n" +
                    "\n" +
                    "Many of us heard about the bill India recently published to control the geospatial information, but were you aware that a ban on unauthorized mapping already exists in Pakistan? This has put a dent in crowdsourced mapping in Pakistan but all is not lost.\n" +
                    "\n" +
                    "Usman will describe how he is trying to create a digital humanitarian society in Pakistan by teaching OSM to the new generations of digital humanitarians. He will offer his perspective gained from 10 years of experience overcoming unique challenges, why it’s important to him, and how Pakistanis can participate in the global humanitarian activities in spite of the ban.\n");
            createEvent(Calendar.SEPTEMBER, 24, 17, 0, 17, 30, "5:00-Comparing OSM data and Brussels local government data ", "Marc Ducobu, Champs-Libres ", R.color.opurple, "Auditorium A", "In 2013, the buildings from the Brussels local government database were incorporated into OSM. Although the local government databases are updated every three months, there is still no process to integrate theses changes into OSM. Having such a process would be beneficial for OSM but also for local government.\n" +
                    "\n" +
                    "Marc will describe a process to compare two databases. Currently, the method uses the Hausdorff distance to detect the differences on the building shapes. He is currently working on the automation of this method and exploring tools like Osmose that help mappers keep the datasets up to date. Find out more.");
        } else {
            //Sunday
            createEvent(Calendar.SEPTEMBER, 25, 9, 0, 9, 59, "9:00-Cofee / Tea", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 25, 10, 0, 10, 29, "10:00-OpenStreetMap Awards & State of the Local Map", "Ilya Zverev, OpenStreetMap Foundation ", R.color.opurple, "Room QA", "\n" +
                    "\n" +
                    "Join us to celebrate the best of OpenStreetMap. The session will be split into two parts. First OpenStreetMap Foundation board member, Ilya Zverev, will present the OSM Awards. This is a chance to celebrate the achievements of the OpenStreetMap community and will culminate in the presentation of the Ulf Möller Memorial Award - an award presented in the memory of Ulf Möller who was killed in January 2012. Known for his smile and his helpful demeanor Ulf was a friend and colleague for many in OpenStreetMap and its Foundation.\n" +
                    "\n" +
                    "Following the awards we will open the floor to members of the community that want to talk about the “State of the Map” in their local region. This is a popular addition to the annual conference and we are always excited to hear how you are getting on across the globe.\n");
            createEvent(Calendar.SEPTEMBER, 25, 10, 30, 10, 59, "Free and Open Space! ", "", R.color.blue_dark, "Nelson Mandela", "All day Sunday, we have Free and Open Space! Collaborate together on coding, mapping, or documentation sprints. Hack. Plan the next big thing. Unlike a Birds of a Feather session this is a non-bookable room; let’s make it a hive of activity open to all");
            createEvent(Calendar.SEPTEMBER, 25, 11, 15, 11, 44, "11:15-Break", "", R.color.blue_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 25, 11, 45, 12, 40, "11:45-Staying on the right side: Best practices in editing", "Simon Poole, Frederik Ramm, Ethan Nelson, OpenStreetMap Foundation ", R.color.oyellow, "Room QA", "\n" +
                    "\n" +
                    "This session will examine best practices in editing conflicts, mechanical editing and editing tools. It comprises three parts.\n" +
                    "\n" +
                    "First, Ethan Nelson will show a few examples of editing disputes he has seen during his time on the Data Working group. Country extents and borders are a highly contentious issue and conflicts inevitably arise in the depiction of these. Ethan will submit practical proposals to better represent diverse global viewpoints of borders.\n" +
                    "\n" +
                    "Frederik Ramm will then explain why so-called “mechanical edits” - edits in which a large number of objects are changed without looking at them individually - can be detrimental to OpenStreetMap. He will outline the frequent pitfalls waiting for those who attempt mechanical edits, and explain the correct procedures for performing them.\n" +
                    "\n" +
                    "Finally, Simon Poole will review editing tools. He will give an overview of some “shoulds” and “don’ts” that both consumer and developers should consider when choosing a tool and developing one. The talk will be peppered with examples of some of the more arcane stuff you need to deal with to avoid criticism for using or writing a tool that breaks stuff.\n");
            createEvent(Calendar.SEPTEMBER, 25, 12, 40, 12, 59, "Free and Open Space!", "", R.color.blue_dark, "Nelson Mandela", "All day Sunday, we have Free and Open Space! Collaborate together on coding, mapping, or documentation sprints. Hack. Plan the next big thing. Unlike a Birds of a Feather session this is a non-bookable room; let’s make it a hive of activity open to all.");
            createEvent(Calendar.SEPTEMBER, 25, 13, 0, 13, 59, "1:00-Lunch", "", R.color.orange_dark, "Vrije Universiteit Brussel", "");
            createEvent(Calendar.SEPTEMBER, 25, 14, 00, 14, 29, "2:00-Station Indoor routing and mapping in practice with OpenStationMap", "Roland Olbricht, Roland Wagner, MENTZ GmbH and Akaparis GmbH ", R.color.brown, "Room QA", "\n" +
                    "\n" +
                    "The typical public transit station is used by tens of thousands of passengers each day. Due to their complexity a lot of mappers feel overwhelmed with editing stations. Furthermore lots of important features like fare gates do not have an established tagging yet.\n" +
                    "\n" +
                    "The Deutsche Bahn (German railways) with Akaparis GmbH and Dynamo Project and MVV with Mentz GmbH have mapped many long distance and metro stations in the last year. On the other hand there are still a large number of stations which are “terra incognita” for OSM. Therefore this workshop invites you to join these activities and to expand this idea of future smart indoor routing and mapping within stations.\n" +
                    "\n" +
                    "We build on the existing and sound work for indoor mapping (Simple Indoor Mapping Schema) and present additions we suggest to map essential and commonplace features in stations. To further ease mapping we would like to present an approach of defining various levels of details. We also present helpful JOSM presets and a JOSM plugin to simplify tagging. We would like to discuss if these ideas go well with the existing indoor viewers and well-known mapping techniques.\n");
            createEvent(Calendar.SEPTEMBER, 25, 14, 30, 15, 14, "Free and Open Space!", "", R.color.blue_dark, "Nelson Mandela", "All day Sunday, we have Free and Open Space! Collaborate together on coding, mapping, or documentation sprints. Hack. Plan the next big thing. Unlike a Birds of a Feather session this is a non-bookable room; let’s make it a hive of activity open to all.");
            createEvent(Calendar.SEPTEMBER, 25, 15, 15, 15, 44, "Break", "", R.color.blue_dark, "Nelson Mandela", "All day Sunday, we have Free and Open Space! Collaborate together on coding, mapping, or documentation sprints. Hack. Plan the next big thing. Unlike a Birds of a Feather session this is a non-bookable room; let’s make it a hive of activity open to all.");
            createEvent(Calendar.SEPTEMBER, 25, 15, 45, 16, 19, "3:45-Making OpenStreetMap navigation ready", " Ramya Ragupathy, Mapbox ", R.color.oyellow, "Room QA", "Map data is increasingly playing a critical role in a world - from smart navigation, to looking towards improved energy efficiency and reducing impact on the environment. More and more users are contributing to OpenStreetMap daily, and the platform already allows for versatile routing for pedestrians, bicycles, and cars, but critical gaps in the data prohibits us from tapping into its full navigation capability.\n" +
                    "\n" +
                    "In this interactive workshop, we’ll look at the gaps and explore tagging schemes, editing tools, visualizations and workflows, and add turn-restriction, turn-lane and bicycle lane data to enhance the navigation potential of OpenStreetMap. At the end of the session, you will have quickly built the incredible skills to create navigation ready data in and around your community");
            createEvent(Calendar.SEPTEMBER, 25, 16, 20, 16, 59, "Free and Open Space!", "", R.color.blue_dark, "Nelson Mandela", "All day Sunday, we have Free and Open Space! Collaborate together on coding, mapping, or documentation sprints. Hack. Plan the next big thing. Unlike a Birds of a Feather session this is a non-bookable room; let’s make it a hive of activity open to all.");
            createEvent(Calendar.SEPTEMBER, 25, 17, 0, 17, 30, "5:00-Closing session VUB Building Q.A", "", R.color.colorAccent, "Vrije Universiteit Brussel", "");
        }
    }

    private void createEvent(Integer month, Integer day, Integer hour, Integer minute, Integer hour2, Integer minute2, String title, String authors, int color, String location, String description) {
        if (location.contains("Vrije Universiteit Brussel")) {
            color =   android.R.color.holo_red_light;
        }
        Calendar start = Calendar.getInstance();
        start.set(2016, month, day, hour, minute);
        Calendar end = Calendar.getInstance();
        end.set(2016, month, day, hour2, minute2);
        //String title, String description, String location, int color, Calendar startTime, Calendar endTime, boolean allDay, int drawableId
        BaseOSMCalendar event = new BaseOSMCalendar(title,
                description, location,
                ContextCompat.getColor(context,
                        color), start,
                end, authors);
        eventList.add(event);
    }
}
