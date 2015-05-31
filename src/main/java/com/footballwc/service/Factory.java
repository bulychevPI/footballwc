package com.footballwc.service;

import com.footballwc.dao.DAO;
import com.footballwc.dao.DAOImpl;
import com.footballwc.entity.Fgroup;
import com.footballwc.entity.Goal;
import com.footballwc.entity.Groupresults;
import com.footballwc.entity.Match;
import com.footballwc.entity.Player;
import com.footballwc.entity.Team;


public class Factory {

	private static Factory instance = null;
	private static DAO<Fgroup> fGroupDAO = null;
	private static DAO<Goal> goalDAO = null;
	private static DAO<Match> matchDAO = null;
	private static DAO<Player> playerDAO = null;
	private static DAO<Team> teamDAO = null;
        private static DAO<Groupresults> GroupresultsDAO = null;

	

	public static synchronized Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	public static DAO<Fgroup> getFGroupDAO() {
		if (fGroupDAO == null)
			fGroupDAO = new DAOImpl<Fgroup>(
					(Class<Fgroup>) (new Fgroup().getClass()));
		return fGroupDAO;
	}

	public static DAO<Goal> getGoalDAO() {
		if (goalDAO == null)
			goalDAO = new DAOImpl<Goal>(
					(Class<Goal>) (new Goal().getClass()));
		return goalDAO;
	}

	public static DAO<Match> getMatchDAO() {
		if (matchDAO == null)
			matchDAO = new DAOImpl<Match>(
					(Class<Match>) (new Match().getClass()));
		return matchDAO;
	}

	public static DAO<Player> getPlayerDAO() {
		if (playerDAO == null)
			playerDAO = new DAOImpl<Player>(
					(Class<Player>) (new Player().getClass()));
		return playerDAO;
	}

	public static DAO<Team> getTeamDAO() {
		if (teamDAO == null)
			teamDAO = new DAOImpl<Team>(
					(Class<Team>) (new Team()
							.getClass()));
		return teamDAO;
	}
        public static DAO<Groupresults> getGroupresultsDAO() {
		if (GroupresultsDAO == null)
			GroupresultsDAO = new DAOImpl<Groupresults>(
					(Class<Groupresults>) (new Groupresults()
							.getClass()));
		return GroupresultsDAO;
	}
	
}
